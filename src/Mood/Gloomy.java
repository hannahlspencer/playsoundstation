package Mood;

public class Gloomy implements Mood {

    private String key = "min";
    private int[] tempoRange = {40, 80};
    private char[] percussiveInstruments = {'`', '+', 'O'};
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
