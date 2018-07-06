package Mood;

public class Downbeat implements Mood {

    private String key = "min";
    private int[] tempoRange = {80, 140};


    public String getKey() {
        return key;
    }

    public int[] getTempoRange() {
        return tempoRange;
    }

    @Override
    public int getBeats() {
        return 0;
    }

    @Override
    public char[] getPercussiveInstruments() {
        return new char[0];
    }
}
