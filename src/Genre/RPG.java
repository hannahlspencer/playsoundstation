package Genre;

public class RPG implements Genre {

    private String[] bassNoteLengths = { "w", "h" };
    private String[] instruments = {"VIOLIN", "VIOLA", "CELLO", "FLUTE", "OCARINA",
            "CLARINET", "ORCHESTRAL_STRINGS"};


    @Override
    public String[] getBassNoteLengths() {
        return bassNoteLengths;
    }

    @Override
    public String[] getInstruments() {
        return instruments;
    }
}
