package Genre;

public class Action implements Genre {

    private String[] bassNoteLengths = { "q", "i" };
    private String[] instruments = {"ROCK_ORGAN", "OVERDRIVEN_GUITAR", "DISTORTION_GUITAR"};

    @Override
    public String[] getBassNoteLengths() {
        return bassNoteLengths;
    }

    @Override
    public String[] getInstruments() {
        return instruments;
    }
}
