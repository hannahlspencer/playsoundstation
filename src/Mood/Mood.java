package Mood;

import java.util.ArrayList;

public interface Mood {

    /**
     * Based on the user input finds a set of music keys that could be used
     * Picks one of these keys at random and returns an ArrayList of possible notes to choose from
     * when constructing a piece of music
     */
    String findKey();

    /**
     * Percussion types and intensity will be decided based on Mood.Mood input.
     * @return String that can be fed into a player that creates percussive sounds
     */
    String addPercussion();

    /**
     * The mood will affect the tempo, eg. sadder moods tend to be slower
     * @return String that will change the tempo of the piece
     */
    String decideTempo();
}
