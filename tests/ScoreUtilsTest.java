import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

public class ScoreUtilsTest {

    @Before
    public void initialise() {
       ScoreUtils.initialise();
    }

    @Test
    public void getAvailableNotes() {
        List notes = ScoreUtils.getAvailableNotes();
        assertTrue(notes instanceof ArrayList);
        assertEquals("A", notes.get(0));
        assertEquals("B", notes.get(1));
        assertEquals("C", notes.get(2));
        assertEquals("D", notes.get(3));
        assertEquals("E", notes.get(4));
        assertEquals("F", notes.get(5));
        assertEquals("G", notes.get(6));
    }

    @Test
    public void getAvailableBassNotes() {
        List notes = ScoreUtils.getAvailableBassNotes();
        assertTrue(notes instanceof ArrayList);
        assertEquals(7, notes.size());
        assertEquals("A3", notes.get(0));
        assertEquals("B3", notes.get(1));
        assertEquals("C3", notes.get(2));
        assertEquals("D3", notes.get(3));
        assertEquals("E3", notes.get(4));
        assertEquals("F3", notes.get(5));
        assertEquals("G3", notes.get(6));
    }

    @Test
    public void checkNoteLengthConversion() {
        assertEquals(4.0, ScoreUtils.checkBar("w"));
        assertEquals(2.0, ScoreUtils.checkBar("h"));
        assertEquals(1.0, ScoreUtils.checkBar("q"));
        assertEquals(0.5, ScoreUtils.checkBar("i"));
        assertEquals(0.0, ScoreUtils.checkBar("x"));
    }

    @Test
    public void checkChooseNoteLength() {
        assertEquals("i", ScoreUtils.chooseNoteLength(3.5));
        String expected = ScoreUtils.chooseNoteLength(3);
        assertTrue((expected == "i") || (expected == "q"));
        expected = ScoreUtils.chooseNoteLength(2.5);
        assertTrue((expected == "i") || (expected == "q"));
        expected = ScoreUtils.chooseNoteLength(2);
        assertTrue((expected == "i") || (expected == "q") || (expected == "h"));
        expected = ScoreUtils.chooseNoteLength(1.5);
        assertTrue((expected == "i") || (expected == "q") || (expected == "h"));
        expected = ScoreUtils.chooseNoteLength(1);
        assertTrue((expected == "i") || (expected == "q") || (expected == "h"));
        expected = ScoreUtils.chooseNoteLength(0.5);
        assertTrue((expected == "i") || (expected == "q") || (expected == "h"));
        expected = ScoreUtils.chooseNoteLength(0);
        assertTrue((expected == "i") || (expected == "q") || (expected == "h") || (expected == "w"));

    }
}
