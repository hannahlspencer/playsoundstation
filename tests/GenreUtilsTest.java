import org.junit.Before;
import org.junit.Test;
import Genre.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GenreUtilsTest {

    @Before
    public void initialise() {
        Genre testGenre = new Action();
        GenreUtils.setGenre(testGenre);
    }

    @Test
    public void setGetGenreTest(){
       assertTrue(GenreUtils.getGenre() instanceof Action);
    }
    


    @Test
    public void getRandomInstrumentTest() {
        String result = GenreUtils.getRandomInstrument();
        List expected = new ArrayList<String>();
        expected.add("ROCK_ORGAN");
        expected.add("OVERDRIVEN_GUITAR");
        expected.add("GUITAR_HARMONICS");
        expected.add("DISTORTION_GUITAR");
        assertTrue(expected.contains(result));
    }

    @Test
    public void setBasslineTestInstrument() {
        List test = new ArrayList<String>();
        test.add("SYNTH_BASS_2");
        test.add("SYNTH_BASS_1");
        test.add("SLAP_BASS_2");
        test.add("SLAP_BASS_1");
        test.add("FRETLESS_BASS");
        test.add("ELECTRIC_BASS_PICK");
        test.add("ELECTRIC_BASS_FINGER");
        test.add("ACOUSTIC_BASS");
        String bass = GenreUtils.setBassInstrument();
        String[] bassSplit = bass.split(" ");
        String bassInstrument = bassSplit[0].replaceAll("[\\[\\] ]", "");
        bassInstrument = bassInstrument.substring(1);
        assertTrue(test.contains(bassInstrument));
    }

    @Test
    public void testGetBassNotes() {
        List notes = Arrays.asList(GenreUtils.getBassNotes());
        assertTrue(notes.size() == 2);
        assertTrue(notes.contains("q"));
        assertTrue(notes.contains("i"));
    }
}
