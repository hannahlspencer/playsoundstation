package Mood;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Upbeat implements Mood {

    private String key = "maj";
    private int[] tempoRange = {120, 160};
    private char[] percussiveInstruments = {'`', 'S', '+', 'O'};
    private int beats = 4;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public int[] getTempoRange() {
        return tempoRange;
    }

    @Override
    public int getBeats() {
        return beats;
    }

    @Override
    public char[] getPercussiveInstruments() {
        return percussiveInstruments;
    }
}
