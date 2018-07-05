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
    }

    @Test
    public void setGenreTest(){
       GenreUtils.setGenre(testGenre);
       assertTrue(GenreUtils.getGenre() instanceof Action);
    }

    @Test
    public void getInstrumentsTest() {
        GenreUtils.setGenre(testGenre);
        GenreUtils.getInstruments();
        String[] expected = {"ROCK_ORGAN", "OVERDRIVEN_GUITAR", "GUITAR_HARMONICS", "DISTORTION_GUITAR"};
        assertEquals(expected, GenreUtils.returnInstruments());
    }


    @Test
    public void getRandomInstrumentTest() {
        GenreUtils.setGenre(testGenre);
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
    public void setBasslineTest() {

    }
}
