import Mood.*;
import org.junit.Before;
import org.junit.Test;
import Genre.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
public class MoodUtilsTest {

    @Before
    public void initialise() {
        Mood testMood = new Happy();
        MoodUtils.setMood(testMood);
    }
    @Test
    public void testSetKey() {
        
    }
}
