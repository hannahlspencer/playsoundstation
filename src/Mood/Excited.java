package Mood;

public class Excited implements Mood {

    private String key = "maj";
    private int[] tempoRange = { 110, 220};
    private int beats = 4;
    private char[] percussiveInstruments = {'O', '`', '+', 'S'};

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

