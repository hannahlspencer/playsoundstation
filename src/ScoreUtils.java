import java.util.ArrayList;
import java.util.List;

public class ScoreUtils {

    private static List<String> availableNotes = new ArrayList<String>();
    private static List<String> availableBassNotes = new ArrayList<String>();

    public static void initialise() {
        initialiseAvailableNotes();
        initialiseBassNotes();
    }

    private static void initialiseAvailableNotes() {
        availableNotes.add("A");
        availableNotes.add("B");
        availableNotes.add("C");
        availableNotes.add("D");
        availableNotes.add("E");
        availableNotes.add("F");
        availableNotes.add("G");
    }

    private static void initialiseBassNotes() {
        availableBassNotes.add("A3");
        availableBassNotes.add("B3");
        availableBassNotes.add("C3");
        availableBassNotes.add("D3");
        availableBassNotes.add("E3");
        availableBassNotes.add("F3");
        availableBassNotes.add("G3");
    }

    public static List<String> getAvailableNotes() {
        return availableNotes;
    }

    public static List<String> getAvailableBassNotes() {
        return availableBassNotes;
    }

    /**
     * Method that helps the makeNewMelody method by returning the representative note lengths so that bars
     * can be established ensuring that each line of melody is the same length
     * @param length - the note that has been selected
     * @return the numeric length of the note
     */
    public static double checkBar(String length) {
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

    /**
     * Method that chooses what note lengths are left that would suit the bar, and picks one at random
     * from the available lengths
     * @param barLength - how many beats are left in the current bar
     * @return a note length that is appropriate for the bar
     */
    public static String chooseNoteLength(double barLength) {
        double overspill = 4 - barLength;
        List<String> adjustedNoteLengths = new ArrayList<>();
        if(overspill == 0.5) {
            adjustedNoteLengths.add("i");
        } else if(overspill > 0.5 && overspill < 2) {
            adjustedNoteLengths.add("q");
            adjustedNoteLengths.add("i");
        } else if(overspill >= 2 && overspill < 4) {
            adjustedNoteLengths.add("q");
            adjustedNoteLengths.add("i");
            adjustedNoteLengths.add("h");
        } else if(overspill == 4) {
            adjustedNoteLengths.add("q");
            adjustedNoteLengths.add("i");
            adjustedNoteLengths.add("h");
            adjustedNoteLengths.add("w");
        }
        return adjustedNoteLengths.get((int) (Math.random() * adjustedNoteLengths.size())).toString();
    }
}
