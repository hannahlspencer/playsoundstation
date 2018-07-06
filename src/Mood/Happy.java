package Mood;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Happy implements Mood {

    private String key = "maj";
    private int[] tempoRange = {120, 160};


    public String getKey() {
        return key;
    }

    public int[] getTempoRange() {
        return tempoRange;
    }

}
