package Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreUtils {

    static List instruments;
    static String genreString;
    static Genre genreClass;

    public static void setGenre(Genre x) {
        genreClass = x;
        String genre = x.getClass().toString();
        String cleanGenre = genre.replace("class ", "");
        genreString = cleanGenre;
    }

    public static String getGenre() {
        return genreString;
    }

    public static void getInstruments() {
        String ins = genreString + "Instruments";
        try {
            Class<?> selection = Class.forName(ins);
            List list = new ArrayList();
            if(selection.isEnum()) {
                list = Arrays.asList(selection.getEnumConstants());
            }
             instruments = list;
        } catch (ClassNotFoundException e) {
            System.out.println("There is not a genre of that type stored with instruments");
            e.printStackTrace();
        }

    }

    public static List returnInstruments() {
        return instruments;
    }

    public static String getRandomInstrument() {
        return instruments.get((int) (Math.random()*instruments.size())).toString();
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
