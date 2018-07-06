package Mood;

public class Gloomy implements Mood {

    private String key = "min";
    private int[] tempoRange = {40, 80};


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
