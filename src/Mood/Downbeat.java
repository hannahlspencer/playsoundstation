package Mood;

public class Downbeat implements Mood {

    private String key = "min";
    private int[] tempoRange = {80, 140};
    private char[] percussiveInstruments = {'O', '`', '+'};
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
