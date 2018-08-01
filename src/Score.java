import Genre.*;
import Mood.*;
import org.jfugue.pattern.Pattern;

import java.util.Arrays;

public class Score implements ScoreInterface {
    public Score(Genre genre, Mood mood) {
        /*
         * The score class itself doesn't need to know the mood and genre, so the constructor passes the knowledge of
         * mood and genre over to the Utils classes and uses those classes directly
         */
        GenreUtils.setGenre(genre);
        MoodUtils.setMood(mood);
    }
    //this will increment with each voice added to the sound
    private int counter = 0;
    //holds the overall score so far
    private String score;

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
        while (bars < 8) {
            String note = notes[(int) (Math.random() * notes.length)];
            String length = "";
            //this checks if it's a bass note
            if(note.contains("3")) {
                String[] noteLengths = GenreUtils.getBassNotes();
                length = chooseBassNoteLength(barLength,noteLengths);
                if(length == "") {
                    note = "R";
                    length = chooseNoteLength(barLength);
                }
            } else {
                length = chooseNoteLength(barLength);
            }
            barLength += checkBar(length);
            melody += (note + length + " ");
            //if the bar length is 4, then a barline is added, the number of bars incremented, and the
            //length of the bar reset to zero
            if(barLength == 4) {
                if(bars < 7) {
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

    private String chooseBassNoteLength(double barLength, String[] notes) {
        double overspill = 4 - barLength;
        System.out.println("Overspill: " + overspill);
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
        if(!Arrays.asList(notes).contains(result)) {
            result = "";
        }
        System.out.println("Result: " + result);
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
            System.out.println("Bass melody " + melody);
        }
    }
    public Pattern getPercussion() {
        return MoodUtils.addPercussion();
    }

    public void updateScore() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "R"};
        //calling setInstrument selects a different random instrument for the next voice
        score = score + startNewVoice() + getInstrument() + makeNewMelody(letters);
    }
}
