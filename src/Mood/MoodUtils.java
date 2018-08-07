
package Mood;
import org.jfugue.pattern.Pattern;
import org.jfugue.rhythm.Rhythm;
import java.util.Random;

public class MoodUtils {

    private static Mood moodClass;

    /**
     * Takes the mood of the piece of music being build and saves it so that other
     * methods can change what they're doing based on the information within that specific class
     * @param mood - subclass of Mood that has been selected by the user
     */
    public static void setMood(Mood mood) {
        moodClass = mood;
    }

    /**
     * getter for the Mood subclass
     * @return Mood subclass
     */
    public static Mood getMood() { return moodClass; }

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
     * Percussion types and intensity will be decided based on Mood.
     * Each mood has a set of percussive instruments relevant to it, and then the method
     * adds a layer of percussion for each instrument
     * Each mood also has a recommended number of beats per 12 beats (to accommodate for all
     * standard time signatures)
     * The for loops start with each recommended instrument, and the second for loop adds up to the
     * number of recommended beats to that layer. The first for loop then adds that layer to the rhythm
     * @return Rhythm type with all the layers that can be fed into a player that creates percussive sounds
     */
    public static Pattern addPercussion() {
        //fetches instruments
        char[] moodPercussion = moodClass.getPercussiveInstruments();
        Rhythm rhythm = new Rhythm();
        //goes through each instrument
        for(int i = 0; i < moodPercussion.length; i++) {
            String start = "........";
            char[] starterRhythm = start.toCharArray();
            Random r = new Random();
            String layer = "";
            //adds in up to the recommended number of instrument noises per beats
            int beats = moodClass.getBeats();
            for(int j = 0; j < beats; j++) {
                char[] p = starterRhythm;
                //picks a random beat to add the selected instrument to
                p[r.nextInt(starterRhythm.length)] = moodPercussion[i];
                layer = new String(p);
            }
            rhythm.addLayer(layer);
        }
        return rhythm.getPattern();
    }

    /**
     * The mood will affect the tempo, eg. sadder moods tend to be slower
     * This method takes the range recommended by the Mood class and chooses a random tempo in between
     * these two numbers.
     * @return String that will state the tempo of the piece
     */
    public static String decideTempo() {
        //Initial notation for tempo in JFugue starts with T
        String initial = "T";
        //recommended range is fetched from the Mood
        int[] range = moodClass.getTempoRange();
        //random number between the two range recommendations is chosen
        Random r = new Random();
        int low = range[0];
        int high = range[1];
        int result = r.nextInt(high-low) + low;
        //initial notation plus the chosen number within the range is returned
        return initial + result;
    }
}
