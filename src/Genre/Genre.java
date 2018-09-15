package Genre;

public interface Genre {
    /**
     * These variables define the archetypal instruments for each genre, and use the lengths of the bass notes to
     * set the underlying tempo of each track
     */
    String[] bassNoteLengths = new String[0];
    String[] instruments = new String[0];

    String[] getBassNoteLengths();
    String[] getInstruments();
}
