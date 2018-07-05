package Genre;

public class Strategy implements Genre {
    private String[] bassNoteLengths = null;
    private String[] instruments = null;


    @Override
    public String[] getBassNoteLengths() {
        return bassNoteLengths;
    }

    @Override
    public String[] getInstruments() {
        return instruments;
    }
}
