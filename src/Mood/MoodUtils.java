
package Mood;

import java.util.Random;

public class MoodUtils {

    private static Mood moodClass;

    /**
     * Takes the mood of the piece of music being build and saves it so that other
     * methods can change what they're doing based on the information within that specific class
     * @param mood
     */
    public static void setMood(Mood mood) {
        moodClass = mood;
    }

    /**
     * Based on the user input finds a set of music keys that could be used
     * Picks one of these keys at random and returns an ArrayList of possible notes to choose from
     * when constructing a piece of music
     */
    public static String setKey() {
        //decides a random note for the key to be in
        String[] letters = {"A", "B", "C", "D", "E", "F", "G"};
        String key = letters[(int) (Math.random() * letters.length)];
        //decides whether the key should be sharp, flat, or neither
        String[] sharpOrFlat = {"#", "b", ""};
        key = key + sharpOrFlat[(int) (Math.random() * sharpOrFlat.length)];
        return key + moodClass.getKey();
    }

    /**
     * Percussion types and intensity will be decided based on Mood.Mood input.
     * @return String that can be fed into a player that creates percussive sounds
     */
    //String addPercussion();

    /**
     * The mood will affect the tempo, eg. sadder moods tend to be slower
     * @return String that will change the tempo of the piece
     */
    public static String decideTempo() {
        String initial = "T";
        int[] range = moodClass.getTempoRange();
        Random r = new Random();
        int low = range[0];
        int high = range[1];
        int result = r.nextInt(high-low) + low;
        return initial + result;
    }
}
