import Mood.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class MoodUtilsTest {

    private Mood testMood;

    @Before
    public void initialise() {
        testMood = new Upbeat();
        MoodUtils.setMood(testMood);
    }

    @Test
    public void setMoodTest(){
        assertTrue(MoodUtils.getMood() instanceof Upbeat);
    }

    @Test
    public void testSetKeyType() {
        String result = MoodUtils.setKey();
        assertTrue(result.contains("maj"));
    }

    @Test
    public void testSetKeyNote() {
        String result = MoodUtils.setKey();
        List test = new ArrayList<Character>();
        test.add('A');
        test.add('B');
        test.add('C');
        test.add('D');
        test.add('E');
        test.add('F');
        test.add('G');
        assertTrue(test.contains(result.charAt(0)));
    }

    @Test
    public void testAddPercussionBeats() {
        String percussionLayers = MoodUtils.addPercussion().toString();
        assertTrue(percussionLayers.contains("PEDAL_HI_HAT"));
        assertTrue(percussionLayers.contains("ACOUSTIC_SNARE"));
        assertTrue(percussionLayers.contains("CRASH_CYMBAL_1"));
        assertTrue(percussionLayers.contains("BASS_DRUM"));
    }

    @Test
    public void testDecideTempoInitial() {
        String result = MoodUtils.decideTempo();
        assertEquals('T', result.charAt(0));
    }

    @Test
    public void testTempoSpeed() {
        String result = MoodUtils.decideTempo();
        result = result.replace("T", "");
        int numResult =Integer.parseInt(result);
        int[] range = testMood.getTempoRange();
        assertTrue((numResult > range[0]) && (numResult < range[1]));
    }
}
