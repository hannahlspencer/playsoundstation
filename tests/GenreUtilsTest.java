import org.junit.Before;
import org.junit.Test;
import Genre.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class GenreUtilsTest {

    GenreUtils tester;
    @Before
    public void initialise() {
        tester = new GenreUtils();
    }

    @Test
    public void setGenreTest(){
       Genre testGenre = new Action();
       tester.setGenre(testGenre);
       assertEquals("Genre.Action", tester.getGenre());

    }
}
