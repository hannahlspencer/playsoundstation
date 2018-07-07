package Mood;

public class Downbeat implements Mood {

    private String key = "min";
    private int[] tempoRange = {80, 140};
    private char[] percussiveInstruments = {'O', '`', '+'};
    private int beats = 4;

    public String getKey() {
        return key;
    }

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
