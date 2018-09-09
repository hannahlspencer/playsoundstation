package Mood;

public class Upbeat implements Mood {

    private String key = "maj";
    private int[] tempoRange = {120, 160};
    private char[] percussiveInstruments = {'`', 'S', '+', 'O'};
    private int beats = 3;

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

