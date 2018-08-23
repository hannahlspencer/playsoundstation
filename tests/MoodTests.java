import Mood.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MoodTests {
    private Mood mood;

    @Test
    public void TestDownbeatKey() {
        mood = new Downbeat();
        assertEquals("min", mood.getKey());
    }

    @Test
    public void testDownbeatPercussionBeats() {
        mood = new Downbeat();
        char[] actual = mood.getPercussiveInstruments();
        assertEquals('O', actual[0]);
        assertEquals('`', actual[1]);
        assertEquals('+', actual[2]);
        assertEquals(2, mood.getBeats());
    }

    @Test
    public void testDownbeatTempo() {
        mood = new Downbeat();
        int[] tempoRange = mood.getTempoRange();
        assertEquals(80, tempoRange[0]);
        assertEquals(140, tempoRange[1]);
    }

    @Test
    public void TestDreamyKey() {
        mood = new Dreamy();
        assertEquals("maj", mood.getKey());
    }

    @Test
    public void testDreamyPercussionBeats() {
        mood = new Dreamy();
        char[] actual = mood.getPercussiveInstruments();
        assertEquals('X', actual[0]);
        assertEquals('`', actual[1]);
        assertEquals('S', actual[2]);
        assertEquals(2, mood.getBeats());
    }

    @Test
    public void testDreamyTempo() {
        mood = new Dreamy();
        int[] tempoRange = mood.getTempoRange();
        assertEquals(60, tempoRange[0]);
        assertEquals(110, tempoRange[1]);
    }

    @Test
    public void TestExcitedKey() {
        mood = new Excited();
        assertEquals("maj", mood.getKey());
    }

    @Test
    public void testExcitedPercussionBeats() {
        mood = new Excited();
        char[] actual = mood.getPercussiveInstruments();
        assertEquals('X', actual[0]);
        assertEquals('O', actual[1]);
        assertEquals('`', actual[2]);
        assertEquals('+', actual[3]);
        assertEquals('S', actual[4]);
        assertEquals(4, mood.getBeats());
    }

    @Test
    public void testExcitedTempo() {
        mood = new Excited();
        int[] tempoRange = mood.getTempoRange();
        assertEquals(110, tempoRange[0]);
        assertEquals(220, tempoRange[1]);
    }

    @Test
    public void TestGloomyKey() {
        mood = new Gloomy();
        assertEquals("min", mood.getKey());
    }

    @Test
    public void testGloomyPercussionBeats() {
        mood = new Gloomy();
        char[] actual = mood.getPercussiveInstruments();
        assertEquals('`', actual[0]);
        assertEquals('+', actual[1]);
        assertEquals('O', actual[2]);
        assertEquals(2, mood.getBeats());
    }

    @Test
    public void testGloomyTempo() {
        mood = new Gloomy();
        int[] tempoRange = mood.getTempoRange();
        assertEquals(40, tempoRange[0]);
        assertEquals(80, tempoRange[1]);
    }

    @Test
    public void TestScaryKey() {
        mood = new Scary();
        assertEquals("min", mood.getKey());
    }

    @Test
    public void testScaryPercussionBeats() {
        mood = new Scary();
        char[] actual = mood.getPercussiveInstruments();
        assertEquals('.', actual[0]);
        assertEquals('`', actual[1]);
        assertEquals(1, mood.getBeats());
    }

    @Test
    public void testScaryTempo() {
        mood = new Scary();
        int[] tempoRange = mood.getTempoRange();
        assertEquals(80, tempoRange[0]);
        assertEquals(160, tempoRange[1]);
    }

    @Test
    public void TestUpbeatKey() {
        mood = new Upbeat();
        assertEquals("maj", mood.getKey());
    }

    @Test
    public void testUpbeatPercussionBeats() {
        mood = new Upbeat();
        char[] actual = mood.getPercussiveInstruments();
        assertEquals('`', actual[0]);
        assertEquals('S', actual[1]);
        assertEquals('+', actual[2]);
        assertEquals('O', actual[3]);
        assertEquals(2, mood.getBeats());
    }

    @Test
    public void testUpbeatTempo() {
        mood = new Upbeat();
        int[] tempoRange = mood.getTempoRange();
        assertEquals(120, tempoRange[0]);
        assertEquals(160, tempoRange[1]);
    }
}
