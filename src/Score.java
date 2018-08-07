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
        barsToWrite = bars;
    }
    //this will increment with each voice added to the sound
    private int counter = 0;
    //holds the overall score so far
    private String score;
    private int barsToWrite;
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
        return " KEY:" + MoodUtils.setKey();
    }


    @Override
    public String getTempo() {
        return MoodUtils.decideTempo();
    }

    @Override
    public void initialiseScore() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "R"};
        score = getTempo() + getKey() + startNewVoice() + getInstrument() + makeNewMelody(letters);
    }

    @Override
    public String makeNewMelody(String[] notes) {
        String melody = "";
        int bars = 0;
        //this variable keeps track of the notes in each bar, and a new bar is created whenever this reaches 4
        double barLength = 0;
        //the for loop selects 16 notes from the pitches and lengths, puts them together and adds them to the melody
        while (bars < barsToWrite) {
            String note = notes[(int) (Math.random() * notes.length)];
            String length;
            //this checks if it's a bass note
            if(note.contains("3")) {
                String[] noteLengths = GenreUtils.getBassNotes();
                length = chooseNoteLength(barLength);
                //this checks that the note returned matches with the note lengths that are appropriate for the Genre being
                //used. If not, then the note is turned into a rest and the length is chosen according to the bar
                if(!Arrays.asList(noteLengths).contains(length)) {
                    note = "R";
                    length = chooseNoteLength(barLength);
                }
            } else {
                length = chooseNoteLength(barLength);
            }
            barLength += checkBar(length);
            melody += (note + length + " ");
            //if the bar length is 4, then a bar line is added, the number of bars incremented, and the
            //length of the bar reset to zero
            if(barLength == 4) {
                if(bars < (barsToWrite -1)) {
                    melody += "| ";
                }
                bars++;
                barLength = 0;
            }
        }
        return melody;
    }

    /**
     * Private method that chooses what note lengths are left that would suit the bar, and picks one at random
     * from the available lengths
     * @param barLength - how many beats are left in the current bar
     * @return a note length that is appropriate for the bar
     */
    private String chooseNoteLength(double barLength) {
        double overspill = 4 - barLength;
        String result = "";
        if(overspill == 4) {
            String[] noteLengths = { "q", "i", "h", "w"};
            result = noteLengths[(int) (Math.random() * noteLengths.length)];
        } else if (overspill >= 2) {
            String[] noteLengths = { "q", "i", "h"};
            result = noteLengths[(int) (Math.random() * noteLengths.length)];
        } else if(overspill >= 1) {
            String[] noteLengths = { "q", "i"};
            result = noteLengths[(int) (Math.random() * noteLengths.length)];
        } else if(overspill >= 0.5) {
            result = "i";
        }
        return result;
    }

    /**
     * Private method that helps the makeNewMelody method by returning the representative note lengths so that bars
     * can be established ensuring that each line of melody is the same length
     * @param length - the note that has been selected
     * @return the numeric length of the note
     */
    private double checkBar(String length) {
        switch(length) {
            case "w" :
                return 4;
            case "h" :
                return 2;
            case "q":
                return 1;
            case "i":
                return 0.5;
            default:
                return 0;
        }
    }

    @Override
    public void addBass() {
        String bassline = GenreUtils.setBassInstrument();
        if(!bassline.equals("")) {
            String[] letters = {"A3", "B3", "C3", "D3", "E3", "F3", "G3", "R"};
            String melody = makeNewMelody(letters);
            score = score + startNewVoice() + bassline + melody;
            System.out.println(score);
        }
    }
    public Pattern getPercussion() {
        return MoodUtils.addPercussion().repeat(barsToWrite);
    }

    public void updateScore() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "R"};
        //calling setInstrument selects a different random instrument for the next voice
        score = score + startNewVoice() + getInstrument() + makeNewMelody(letters);
    }
}
