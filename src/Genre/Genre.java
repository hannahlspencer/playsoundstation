package Genre;

public interface Genre {


    /**
     * Assigns instruments from the enum class set in identifyInstruments to lines of melody within the
     * musical score String and returns this String
     * @return String with relevant instrument put into place
     */
    String selectInstruments();

    /**
     * The prominance of a bassline will be defined by genre. This method adds a new line of melody using
     * a bass instrument
     * @param score - takes the String built up so far
     * @return updated score with a layer of bass melody (what instrument?)
     */
    String setBassline(String score);

}
