package Genre;
public class Puzzler implements Genre {

    private String[] bassNoteLengths = { "w", "h", "q", "i" };
    private String[] instruments = {"CHOIR", "CRYSTAL", "BOWED",  "SAWTOOTH"};


    @Override
    public String[] getBassNoteLengths() {
        return bassNoteLengths;
    }

    @Override
    public String[] getInstruments() {
        return instruments;
    }
}
