package Mood;

import java.util.ArrayList;

public interface Mood {

    String key = "";
    int[] tempoRange = new int[0];
    char[] percussiveInstruments = new char[0];
    int beats = 0;
    
    String getKey();

    int[] getTempoRange();
    int getBeats();
    char[] getPercussiveInstruments();

}
