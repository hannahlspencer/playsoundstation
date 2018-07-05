
package Mood;

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
    public static void setKey() {
        //decides a random note for the key to be in
        String[] letters = {"A", "B", "C", "D", "E", "F", "G"};
        String key = letters[(int) (Math.random() * letters.length)];
        //decides whether the key should be sharp, flat, or neither
        String[] sharpOrFlat = {"#", "b", ""};
        key = key + sharpOrFlat[(int) (Math.random() * sharpOrFlat.length)];

    }

}
