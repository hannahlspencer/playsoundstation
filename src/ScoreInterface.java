import org.jfugue.pattern.Pattern;

public interface ScoreInterface {

    /**
     * This method sets up the first part of the String that will become a line of melody (or voice) in the score then
     * increments the counter so that it's ready to add more lines of melody if necessary
     * @return A String with the characters " V" and then a number representing which voice it is
     */
    String startNewVoice();

    /**
     * A getter for the score so far
     * @return A String representation of the score that has been built up
     */
    String getScore();

    /**
     * This method calls to the GenreUtils class to fetch the appropriate instruments for the Genre that has been selected
     * by the user. It then retrieves a random instruments from the GenreUtils class and saves it to an internal variable,
     * surrounding it with appropriate notation.
     * For example, if a violin had been selected the String saved would be " I[VIOLIN] "
     */
    String getInstrument();


    /**
     * A getter for the key selected in setKey()
     * @return A String holding the selected key and appropriate notation (see doc for setKey)
     */
    String getKey();

    /**
     * Retrieves appropriate tempo from MoodUtils and saves it to a local variable
     */
    String getTempo();

    /**
     * Adds together the tempo, key, voice, instrument, and then calls the method to make a new melody to create the first
     * part of the score, saving it to a local variable
     */
    void initialiseScore();

    /**
     * This method randomly creates a String of notes paired with note lengths as a representation of a melody
     * @return String representing the melody that the score will play
     */
    String makeNewMelody();

    /**
     * Retrieves bassline from GenreUtils
     * In some cases, no bassline will be provided. If this is not the case, a new voice will be started and
     * the bassline added to the score
     */
    void addBass();

    /**
     * Getter for percussion variable
     * @return Pattern class of the percussion made for the piece
     */
    Pattern getPercussion();

    /**
     * Adds a new voice to the score with another instrument and new melody
     */
    void updateScore();
}
