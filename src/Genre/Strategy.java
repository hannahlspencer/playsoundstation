package Genre;

public class Strategy implements Genre {

    private String[] bassNoteLengths = {"w", "h"};
    private String[] instruments = {"TRUMPET", "MUTED_TRUMPET", "TUBA", "VIOLIN"};

    @Override
    public String[] getBassNoteLengths() {
        return bassNoteLengths;
    }

    @Override
    public String[] getInstruments() {
        return instruments;
    }
}
