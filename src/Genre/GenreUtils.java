package Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreUtils {
    public static String getInstrument(Genre x) {
        String y = x.getClass().toString();
        String ins = y + "Instruments";
        ins = ins.replace("class ", "");

        try {
            Class<?> instruments = Class.forName(ins);
            List list = new ArrayList();
            if(instruments.isEnum()) {
                list = Arrays.asList(instruments.getEnumConstants());
            }
             Object instrument =
                     list.get((int)(Math.random()*list.size()));
            return "[" + instrument + "] ";
        } catch (ClassNotFoundException e) {
            System.out.println("There is not a genre of that type stored with instruments");
            e.printStackTrace();
        }

        return y;

    }
}
