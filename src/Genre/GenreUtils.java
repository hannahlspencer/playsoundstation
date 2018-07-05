package Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreUtils {

    private static String[] instruments;
    private static Genre genreClass;

    /**
     * Takes the genre of the piece of music being build and saves it so that other
     * methods can change what they're doing based on the information within that specific genre class
     * @param genre
     */
    public static void setGenre(Genre genre) {
        genreClass = genre;
    }

    /**
     *
     * @return the class of the Genre being used
     */
    public static Genre getGenre() {
        return genreClass;
    }

    /**
     * saves the instruments that can be used from the Genre class being considered
     */
    public static void setInstruments() {
        instruments = genreClass.getInstruments();
    }

    /**
     *
     * @return the instruments that have been saved from the Genre class
     */
    public static String[] returnInstruments() {
        return instruments;
    }

    /**
     * From the instruments that have been saved from the genre class, selects one at random to
     * use for the line of melody being considered
     * @return random instrument as a String to use in a String of melody
     */

    public static String getRandomInstrument() {
        return instruments[(int) (Math.random()*instruments.length)].toString();
    }

    /**
     *  Selects a random Bass instrument to use for the bassline of the piece of music,
     *  then random selects a series of notes or rests to be used for that bassline
     * @param numOfNotes
     * @return String that contains the bass melody and instrument
     */
    public static String setBassline(int numOfNotes) {
        BassInstruments instrument =
                BassInstruments.values()[(int)(Math.random()*BassInstruments.values().length)];
        String[] noteLengths = genreClass.getBassNoteLengths();
        String[] letters = {"A3", "B3", "C3", "D3", "E3", "F3", "G3", "R"};

        String melody = "";
        for(int i = 0; i < numOfNotes; i++) {
            String note = letters[(int) (Math.random() * letters.length)];
            String length = noteLengths[(int) (Math.random() * noteLengths.length)];

            melody += (note + length + " ");
        }
        return "I[" + instrument + "] " + melody;
    }
}
