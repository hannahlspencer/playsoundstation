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
        genre = new RPG();
        mood = new Scary();
        score = new Score(genre, mood, 8);
    }

    @Test
    public void initialiseUtilsTest() {
        assertTrue(GenreUtils.getGenre() instanceof RPG);
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
        assertEquals('I', instrument.charAt(0));
        assertEquals('[', instrument.charAt(1));
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
        assertEquals('I', scoreComponents[3].charAt(0));
        assertEquals('[', scoreComponents[3].charAt(1));
    }

    @Test
    public void updateScoreTest() {
        score.initialiseScore();
        score.updateScore();
        //ensures there's a second voice that's been added
        assertTrue(score.getScore().contains("V1"));
    }

    @Test
    public void fixFinalNoteTest() {
        score.initialiseScore();
        String fixedScore = score.getScore();
        String key = fixedScore.split(" ")[1];
        String tonic = key.substring(4, key.length()).replaceAll("['min''maj'' ''#''b']", "");
        String finalNote = fixedScore.substring(fixedScore.length() - 3,fixedScore.length() -2 );
        assertEquals(tonic, finalNote);
    }

    @Test
    public void fixFinalNoteTestBass() {
        score.initialiseScore();
        score.addBass();
        String fixedScore = score.getScore();
        String key = fixedScore.split(" ")[1];
        String tonic = key.substring(4, key.length()).replaceAll("['min''maj'' ''#''b']", "");
        //as bass is added last, the final note will always be a bass line note
        String finalNote = fixedScore.substring(fixedScore.length() - 4,fixedScore.length() -2 )
                .replaceAll("['3'' ']", "");
        assertEquals(tonic, finalNote);
    }

    @Test
    public void testKeyProgressionChange() {
        String key = score.getKey() + " ";
        String keyToChange = key.substring(5, key.length()).replaceAll("['min''maj'' ''#''b']", "");

        //expected note progressions
        switch(keyToChange) {
            case "A":
                key = "E";
                break;
            case "B":
                key = "F";
                break;
            case "C":
                key = "G";
                break;
            case "D":
                key = "A";
                break;
            case "E":
                key = "B";
                break;
            case "F":
                key = "C";
                break;
            case "G":
                key = "D";
                break;
        }

        assertTrue(score.keyProgression(true).contains(key));
    }
    @Test
    public void testKeyProgressionReturn() {
        String key = score.getKey() + " ";
        assertEquals(key,score.keyProgression(false) );
    }
}
