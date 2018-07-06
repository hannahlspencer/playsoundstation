package Mood;

public class Dreamy implements Mood {
    private String key = "maj";
    private int[] tempoRange = {60, 110};
    private String[] percussiveInstruments = new String[0];


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
