package Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreUtils {

    static List instruments;
    static String genre;

    public static void setGenre(Genre x) {
        String y = x.getClass().toString();
        String ins = y.replace("class ", "");
        genre = ins;
    }

    public static void getInstruments() {
        String ins = genre + "Instruments";
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

    public static String getRandomInstrument() {
        return instruments.get((int) (Math.random()*instruments.size())).toString();
    }
}
