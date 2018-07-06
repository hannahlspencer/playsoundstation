
package Mood;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;
import org.jfugue.theory.ChordProgression;

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
     * From a series of notes, defines a set of keys that could be used
     * Picks one of these keys at random and returns the String of the key, including
     * whether it should be major or minor dependent on the Mood
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
     * @return Rhythm type that can be fed into a player that creates percussive sounds
     */
    public static Rhythm addPercussion() {
        char[] moodPercussion = moodClass.getPercussiveInstruments();
        Rhythm rhythm = new Rhythm();
        for(int i = 0; i < moodPercussion.length; i++) {
            char[] starterRhythm = "........".toCharArray();
            Random r = new Random();
            String layer = "";
            for(int j = 0; j < moodClass.getBeats(); j++) {
                char[] p = starterRhythm;
                p[r.nextInt(starterRhythm.length)] = moodPercussion[i];
                layer = new String(p);
            }
            System.out.println(layer);
            rhythm.addLayer(layer);
        }
        return rhythm;
    }

    /**
     * The mood will affect the tempo, eg. sadder moods tend to be slower
     * This method takes the range recommended by the Mood class and chooses a random tempo in between
     * these two numbers.
     * @return String that will state the tempo of the piece
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
