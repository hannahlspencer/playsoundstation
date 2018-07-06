package Mood;

public class Scary implements Mood {

    private String key = "min";
    private int[] tempoRange = {80, 160};
    private String[] percussiveInstruments = { "SIDE_STICK", "HI_WOOD_BLOCK", "LOW_WOOD_BLOCK", "CRASH_CYMBAL_1"
                                                    , "BASS_DRUM"};


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
