import org.junit.Before;
import org.junit.Test;
import Genre.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GenreUtilsTest {

    private Genre testGenre;

    @Before
    public void initialise() {

        testGenre = new Action();
        GenreUtils.setGenre(testGenre);

    }

    @Test
    public void setGenreTest(){
       assertTrue(GenreUtils.getGenre() instanceof Action);
    }

    @Test
    public void getInstrumentsTest() {
        GenreUtils.getInstruments();
        String[] expected = {"ROCK_ORGAN", "OVERDRIVEN_GUITAR", "GUITAR_HARMONICS", "DISTORTION_GUITAR"};
        String[] result = GenreUtils.returnInstruments();
        assertTrue(Arrays.equals(expected, result));
    }


    @Test
    public void getRandomInstrumentTest() {
        GenreUtils.getInstruments();
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
        String bass = GenreUtils.setBassline(2);
        String[] bassSplit = bass.split(" ");
        String bassInstrument = bassSplit[0].replaceAll("[\\[\\]I]", "");
        assertTrue(test.contains(bassInstrument));
    }


    @Test
    public void setBasslineCheckNotes1() {
        String bass = GenreUtils.setBassline(2);
        String[] bassSplit = bass.split(" ");
        assertTrue(bassSplit.length == 3);
    }

    @Test
    public void setBasslineCheckNotes0() {
        String bass = GenreUtils.setBassline(0);
        String[] bassSplit = bass.split(" ");
        assertTrue(bassSplit.length == 1);
    }
    @Test
    public void setBasslineCheckNotes25() {
        String bass = GenreUtils.setBassline(25);
        String[] bassSplit = bass.split(" ");
        assertTrue(bassSplit.length == 26);
    }
}
