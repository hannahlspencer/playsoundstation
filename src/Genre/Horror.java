package Genre;

public class Horror implements Genre{

    String[] bassNoteLengths = { "w"};
    String[] instruments = {"VIOLIN", "VIOLA", "CELLO", "CHOIR_OOHS", "CHOIR_AAHS", "SYNTH_VOICE", "CRYSTAL","TUBULAR_BELLS",
            "MUSIC_BOX", "BREATH_NOISE", "METALLIC"};

    @Override
    public String[] getBassNoteLengths() {
        return bassNoteLengths;
    }

    @Override
    public String[] getInstruments() {
        return instruments;
    }
}
