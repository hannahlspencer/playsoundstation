import Genre.*;
import Mood.*;
import org.jfugue.pattern.Pattern;

import java.util.Arrays;
import java.util.List;

public class Score implements ScoreInterface {
    public Score(Genre genre, Mood mood, int bars) {
        /*
         * The score class itself doesn't need to know the mood and genre, so the constructor passes the knowledge of
         * mood and genre over to the Utils classes and uses those classes directly
         */
        GenreUtils.setGenre(genre);
        MoodUtils.setMood(mood);
        ScoreUtils.initialise();
        barsToWrite = bars;
    }
    //this will increment with each voice added to the sound
    private int voiceCounter = 0;
    //holds the overall score so far
    private String score;
    //counts down how many more bars need to be written
    private int barsToWrite;
    //stores current main key of the score
    private String key;

    public int getCounter() {
        return voiceCounter;
    }

    @Override
    public String startNewVoice() {
        String result = " V" + voiceCounter + " ";
        voiceCounter++;
        return result;
    }

    @Override
    public String getScore() {
        return score;
    }

    @Override
    public String getInstrument() {
        return "I[" + GenreUtils.getRandomInstrument() + "] ";
    }

    @Override
    public String getKey() {
        key = " KEY:" + MoodUtils.setKey();
        return key;
    }


    @Override
    public String getTempo() {
        return MoodUtils.decideTempo();
    }

    @Override
    public void initialiseScore() {
        List notes = ScoreUtils.getAvailableNotes();
        score = getTempo() + getKey() + startNewVoice() + getInstrument() + makeNewMelody(notes);
        System.out.println("Initialise score: " + score);
    }

    @Override
    public String makeNewMelody(List<String> notes) {

        String melody = "";
        int bars = 0;
        //this variable keeps track of the notes in each bar, and a new bar is created whenever this reaches 4
        double barLength = 0;
        int thirds = barsToWrite/3;
        //these booleans keep track of whether the key change has happened yet
        Boolean keyChanged = false;
        Boolean keyReturned = false;
        //writes the actual music
        while (bars < barsToWrite) {
            //changes key to the V progression a third of the way through the piece
            if (bars == thirds && !keyChanged) {
                keyChanged = true;
                melody += keyProgression(true);
            }
            //returns the piece to the original key two thirds of the way through the piece
            if(bars == thirds * 2 && !keyReturned) {
                keyReturned = true;
                melody += keyProgression(false);
            }

            //goes note by note
            String note = notes.get((int) (Math.random() * notes.size()));
            String length;
            //this checks if it's a bass note
            if(note.contains("3")) {
                //if a bass note, then the appropriate bass note lengths are fetched
                String[] noteLengths = GenreUtils.getBassNotes();

                // chooses a random note length appropriate to the beats left in the bar
                length = ScoreUtils.chooseNoteLength(barLength);
                //this checks that the note returned matches with the note lengths that are appropriate for the Genre being
                //used. If not, then the note is turned into a rest
                if(!Arrays.asList(noteLengths).contains(length)) {
                    note = "R";
                }
            } else {
                //if note is not a bass note the length is chosen as normal without consulting anything else
                length = ScoreUtils.chooseNoteLength(barLength);
            }

            //adds the length of the note just chosen to how many notes are currently in the bar
            barLength += ScoreUtils.checkBar(length);
            //adds note and length to melody
            melody += (note + length + " ");
            //if the bar length is 4, then a bar line is added, the number of bars incremented, and the
            //length of the bar reset to zero
            if(barLength == 4) {
                //if there are still bars left to write, a bar line is added
                if(bars < (barsToWrite - 1)) {
                    melody += "| ";
                }
                //if this is the final bar, the final note is turned into the tonic
                if(bars == barsToWrite - 1) {
                    melody = fixFinalNote(melody);
                }
                bars++;
                barLength = 0;
            }
        }
        return melody;
    }


    @Override
    public String keyProgression(Boolean newKey) {
        //if the newKey is true then the key needs to be changed to the V progression of the original key
        if(newKey) {
            int count = 4;
            //removes key information to only leave the letter note
            String keyToChange = key.substring(5, key.length()).replaceAll("['min''maj'' ''#''b']", "");

            int asciiKey = keyToChange.charAt(0);
            //uses ascii values of the notes to find the fifth next one, looping round if it gets to G/71
            while(count > 0) {
                if(asciiKey == 71) {
                    asciiKey = 65;
                } else {
                    asciiKey += 1;
                }
                count--;
            }
            char charKey = (char) asciiKey;
            String updatedKey = "KEY:";
            updatedKey += String.valueOf(charKey);
            //reverses whether the key is minor or major for the progression
            if(key.contains("maj")) {
                updatedKey += "min ";
            } else {
                updatedKey += "maj ";
            }

            return updatedKey;
        } else {
            //if the key needs changing back, reverts back to the original key stored as a global variable
            return key + " ";
        }
    }

    @Override
    public String fixFinalNote(String melody) {
        //finding the tonic note for the piece from the key signature
        String tonic = key.substring(5, key.length()).replaceAll("['min''maj'' ''#''b']", "");
        int noteToMinus = 3;
        if(melody.substring(melody.length() - 3, melody.length()).contains("3")) {
            noteToMinus = 4;
        }
        String noteToChange = melody.substring(melody.length() - noteToMinus, melody.length());
        String replace = noteToChange.replace(noteToChange.charAt(0), tonic.charAt(0) );
        String newMelody = melody.substring(0, melody.length() - noteToMinus);
        newMelody += replace;
        return newMelody;
    }

    @Override
    public void addBass() {
        String bassline = GenreUtils.setBassInstrument();
        if(!bassline.equals("")) {
            List notes = ScoreUtils.getAvailableBassNotes();
            String melody = makeNewMelody(notes);
            score = score + startNewVoice() + bassline + melody;
            System.out.println("Add bassline: " + score);
        }

    }
    public Pattern getPercussion() {
        Pattern drums1 = MoodUtils.addPercussion().repeat(barsToWrite/4);
        Pattern drums2 = MoodUtils.addPercussion().repeat(barsToWrite/4);
        return new Pattern(drums1, drums2, drums2, drums1);
    }

    public void updateScore() {
        List notes = ScoreUtils.getAvailableNotes();
        //calling setInstrument selects a different random instrument for the next voice
        score = score + startNewVoice() + getInstrument() + makeNewMelody(notes);
        System.out.println("Update score: " + score);
    }

}
