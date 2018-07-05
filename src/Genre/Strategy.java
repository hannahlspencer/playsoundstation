package Genre;

public class Strategy implements Genre {
    private String[] bassNoteLengths = {"w", "h"};
    private String[] instruments = {"VIBRAPHONE", "TRUMPET", "MUTED_TRUMPET", "TUBA"};


    @Override
    public String[] getBassNoteLengths() {
        return bassNoteLengths;
    }

    @Override
    public String[] getInstruments() {
        return instruments;
    }
}
