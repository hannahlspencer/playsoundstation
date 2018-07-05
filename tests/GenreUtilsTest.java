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
       assertEquals("Genre.Action", GenreUtils.getGenre());
    }

    @Test
    public void getInstrumentsTest() {
        GenreUtils.setGenre(testGenre);
        GenreUtils.getInstruments();
        assertEquals(Arrays.asList(ActionInstruments.values()), GenreUtils.returnInstruments());
    }

    @Test
    public void getInstrumentTestFail() {
        Genre test = new TestFail();
        GenreUtils.setGenre(test);
        GenreUtils.getInstruments();
        assertTrue(GenreUtils.returnInstruments() == null);
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
