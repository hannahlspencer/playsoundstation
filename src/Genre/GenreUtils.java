package Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreUtils {

    private static String[] instruments;
    private static Genre genreClass;

    public static void setGenre(Genre x) {
        genreClass = x;
    }

    public static Genre getGenre() {
        return genreClass;
    }

    public static void getInstruments() {
        instruments = genreClass.getInstruments();
    }

    public static String[] returnInstruments() {
        return instruments;
    }

    public static String getRandomInstrument() {
        return instruments[(int) (Math.random()*instruments.length)].toString();
    }

    public static String setBassline(int numOfNotes) {
        BassInstruments instrument =
                BassInstruments.values()[(int)(Math.random()*BassInstruments.values().length)];
        String[] noteLengths = genreClass.bassNoteLengths;
        String[] letters = {"A3", "B3", "C3", "D3", "E3", "F3", "G3", "R3"};

        String melody = "";
        for(int i = 0; i < numOfNotes; i++) {
            String note = letters[(int) (Math.random() * letters.length)];
            String length = noteLengths[(int) (Math.random() * noteLengths.length)];
            melody += (note + length + " ");
        }
        return "I[" + instrument + "] " + melody;
    }
}
