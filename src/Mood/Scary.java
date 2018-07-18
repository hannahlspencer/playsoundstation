package Mood;

public class Scary implements Mood {

    private String key = "min";
    private int[] tempoRange = {80, 160};
    private char[] percussiveInstruments = { '.'};
    private int beats = 2;

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
