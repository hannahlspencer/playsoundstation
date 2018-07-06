package Genre;
public class Puzzler implements Genre {

    private String[] bassNoteLengths = { "w", "h", "q", "i" };
    private String[] instruments = {"CHOIR", "CRYSTAL", "BOWED",  "SAWTOOTH", "ELECTRIC_JAZZ_GUITAR"};


    @Override
    public String[] getBassNoteLengths() {
        return bassNoteLengths;
    }

    @Override
    public String[] getInstruments() {
        return instruments;
    }
}
