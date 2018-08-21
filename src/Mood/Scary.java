package Mood;

public class Scary implements Mood {

    private String key = "min";
    private int[] tempoRange = {110, 220};
    private char[] percussiveInstruments = { '.', '`'};
    private int beats = 1;

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
