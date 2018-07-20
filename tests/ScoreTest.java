import org.jfugue.pattern.Pattern;
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
        assertEquals(score.getCounter(), 1);
    }

    @Test
    public void checkStartNewVoiceString() {
        assertEquals(" V0 ", score.startNewVoice());
    }

    @Test
    public void checkStartNewVoiceStringWithIncrease() {
        score.startNewVoice();
        score.startNewVoice();
        assertEquals(" V2 ", score.startNewVoice());
    }

    @Test
    public void checkInstrumentNotation() {
        score.getInstrument();
        String instrument = score.getInstrument();
        assertEquals(' ', instrument.charAt(0));
        assertEquals('I', instrument.charAt(1));
        assertEquals('[', instrument.charAt(2));
        assertEquals(']', instrument.charAt(instrument.length() - 2));
    }

    @Test
    public void checkAppropriateInstrument() {
        score.getInstrument();
        String instrument = score.getInstrument();
        instrument = instrument.replaceAll("[\\[\\] ]", "");
        instrument = instrument.substring(1);
        List instruments = Arrays.asList(genre.getInstruments());
        assertTrue(instruments.contains(instrument));
    }

    @Test
    public void checkSetKeyInitial() {
        score.getKey();
        String initialString = score.getKey().substring(0, 5);
        assertEquals(" KEY:", initialString);
    }
    @Test
    public void checkSetKeyEnd() {
        score.getKey();
        String endString = score.getKey();
        endString = endString.substring(endString.length() - 3, endString.length());
        assertEquals("min", endString);
    }

    @Test
    public void checkNotes() {
        score.getKey();
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
        //if there's more than 2 characters, check the other character is a sharp or flat
        if(note.length() == 2) {
            assertTrue(note.charAt(1) == '#' || note.charAt(1) == 'b');
        }
    }

    @Test
    public void testDecideTempoInitial() {
        String result = score.getTempo();
        assertEquals('T', result.charAt(0));
    }

    @Test
    public void testTempoSpeed() {
        String result = score.getTempo();
        result = result.replace("T", "");
        int numResult =Integer.parseInt(result);
        int[] range = mood.getTempoRange();
        assertTrue((numResult > range[0]) && (numResult < range[1]));
    }

    @Test
    public void checkInitialisingScore() {
        score.initialiseScore();
        String[] scoreComponents = score.getScore().split(" ");
        //checks tempo notation is at the beginning
        assertEquals('T', scoreComponents[0].charAt(0));
        //checks the key is next
        assertTrue(scoreComponents[1].contains("KEY:"));
        assertTrue(scoreComponents[1].contains("min"));
        //checks the voice is the first one
        assertEquals("V0", scoreComponents[2] );
        //skips one due to an extra space; checks the Instrument is next
        assertEquals('I', scoreComponents[4].charAt(0));
        assertEquals('[', scoreComponents[4].charAt(1));
    }

    @Test
    public void updateScoreTest() {
        score.initialiseScore();
        score.updateScore();
        //ensures there's a second voice that's been added
        assertTrue(score.getScore().contains("V1"));
    }
}
