package Mood;

public class Dreamy implements Mood {

    private String key = "maj";
    private int[] tempoRange = {60, 110};
    private char[] percussiveInstruments = {'X', '`', 'S'};
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
