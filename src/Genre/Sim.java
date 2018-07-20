package Genre;

public class Sim implements Genre {

    private String[] bassNoteLengths = { "w", "q", "h" };
    private String[] instruments = {"NEW_AGE", "SWEEP", "WARM", "POLY_SYNTH", "CHOIR",
            "BOWED", "METALLIC", "HALO", "SYNTH_BRASS_1", "SYNTH_BRASS_2"};

    @Override
    public String[] getBassNoteLengths() {
        return bassNoteLengths;
    }

    @Override
    public String[] getInstruments() {
        return instruments;
    }
}
