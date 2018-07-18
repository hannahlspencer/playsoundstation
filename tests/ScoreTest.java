import org.junit.Before;
import Genre.*;
import Mood.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ScoreTest {

    private Genre genre;
    private Mood mood;
    private Score score;
    @Before
    public void initialise() {
        genre = new Horror();
        mood = new Scary();
        score = new Score(genre, mood);
    }

    @Test
    public void initialiseUtilsTest() {
        assertTrue(GenreUtils.getGenre() instanceof Horror);
        assertTrue(MoodUtils.getMood() instanceof Scary);
    }

    @Test
    public void checkStartNewVoice() {
        score.startNewVoice();
        assertEquals(score.counter, 1);
    }

    @Test
    public void checkStartNewVoiceString() {
        assertEquals(" V0", score.startNewVoice());
    }

    @Test
    public void checkStartNewVoiceStringWithIncrease() {
        score.startNewVoice();
        score.startNewVoice();
        assertEquals(" V2", score.startNewVoice());
    }

    @Test
    public void checkInstruments() {
        score.setInstrument();
        String instrument = score.getInstrument();
        assertEquals(' ', instrument.charAt(0));
        assertEquals('I', instrument.charAt(1));
        assertEquals('[', instrument.charAt(2));
        assertEquals(']', instrument.charAt(instrument.length() - 2));
    }

    @Test
    public void checkAppropriateInstrument() {
        score.setInstrument();
        String instrument = score.getInstrument();
        instrument = instrument.replaceAll("[\\[\\] ]", "");
        instrument = instrument.substring(1);
        List instruments = Arrays.asList(genre.getInstruments());
        assertTrue(instruments.contains(instrument));
    }

    @Test
    public void checkSetKeyInitial() {
        score.setKey();
        String initialString = score.getKey().substring(0, 5);
        assertEquals(" KEY:", initialString);
    }
    @Test
    public void checkSetKeyEnd() {
        score.setKey();
        String endString = score.getKey();
        endString = endString.substring(endString.length() - 3, endString.length());
        assertEquals("min", endString);
    }

    @Test
    public void checkNotes() {
        score.setKey();
        String note = score.getKey();
        note = note.substring(5, note.length() - 3);
        List notes = new ArrayList<Character>();
        notes.add('A');
        notes.add('B');
        notes.add('C');
        notes.add('D');
        notes.add('E');
        notes.add('F');
        notes.add('G');
        assertTrue(notes.contains(note.charAt(0)));
        if(note.length() == 2) {
            assertTrue(note.charAt(1) == '#' || note.charAt(1) == 'b');
        }
    }


}
