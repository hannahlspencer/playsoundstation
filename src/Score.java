import Genre.*;
import Mood.*;
import org.jfugue.pattern.Pattern;

import java.util.ArrayList;
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
    private int counter = 0;
    //holds the overall score so far
    private String score;
    private int barsToWrite;
    private String key;
    private List<String> notes = new ArrayList<>();

    public int getCounter() {
        return counter;
    }

    @Override
    public String startNewVoice() {
        String result = " V" + counter + " ";
        counter++;
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
        //the for loop selects 16 notes from the pitches and lengths, puts them together and adds them to the melody
        int thirds = barsToWrite/3;
        Boolean keyChanged = false;
        Boolean keyReturned = false;
        while (bars < barsToWrite) {
            if (bars == thirds && !keyChanged) {
                keyChanged = true;
                melody += keyProgression(true);
            }
            if(bars == thirds * 2 && !keyReturned) {
                keyReturned = true;
                melody += keyProgression(false);
            }
            String note = notes.get((int) (Math.random() * notes.size()));
            String length;
            //this checks if it's a bass note
            if(note.contains("3")) {
                String[] noteLengths = GenreUtils.getBassNotes();
                length = ScoreUtils.chooseNoteLength(barLength);
                //this checks that the note returned matches with the note lengths that are appropriate for the Genre being
                //used. If not, then the note is turned into a rest and the length is chosen according to the bar
                if(!Arrays.asList(noteLengths).contains(length)) {
                    note = "R";
                    length = ScoreUtils.chooseNoteLength(barLength);
                }
            } else {
                length = ScoreUtils.chooseNoteLength(barLength);
            }
            barLength += ScoreUtils.checkBar(length);
            melody += (note + length + " ");
            //if the bar length is 4, then a bar line is added, the number of bars incremented, and the
            //length of the bar reset to zero
            if(barLength == 4) {
                if(bars < (barsToWrite -1)) {
                    melody += "| ";
                }
                if(bars == barsToWrite - 1) {
                    melody = fixFinalNote(melody);
                }
                bars++;
                barLength = 0;
            }
        }
        return melody;
    }





    public String keyProgression(Boolean newKey) {
        if(newKey) {
            int count = 4;
            String keyToChange = key.replaceAll("['KEY:''min''maj'' ''#''b']", "");
            if(keyToChange.equals("")) {
                keyToChange = "E";
            }
            char progress = keyToChange.charAt(0);
            int asciiKey = progress;
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
            if(key.contains("maj")) {
                updatedKey += "min ";
            } else {
                updatedKey += "maj ";
            }

            return updatedKey;
        } else {
            return key + " ";
        }
    }

    public String fixFinalNote(String melody) {
        //finding the tonic note for the piece from the key signature
        String tonic = key.replaceAll("['KEY:''min''maj'' ''#''b']", "");

        if(tonic.equals("")){
            tonic = "E";
        }
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
        Pattern drums1 = MoodUtils.addPercussion(barsToWrite).repeat(barsToWrite/4);
        Pattern drums2 = MoodUtils.addPercussion(barsToWrite).repeat(barsToWrite/4);
        return new Pattern(drums1, drums2, drums2, drums1);
    }

    public void updateScore() {
        List notes = ScoreUtils.getAvailableNotes();
        //calling setInstrument selects a different random instrument for the next voice
        score = score + startNewVoice() + getInstrument() + makeNewMelody(notes);
        System.out.println("Update score: " + score);
    }

}
