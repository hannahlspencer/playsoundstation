import Genre.*;
import Mood.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ScoreBuilderTests {
    private String[] scoreComponents;
    @Before
    public void initialise() {
        scoreComponents = ScoreBuilder.runGenerator(new Strategy(), new Gloomy()).toString().split(" ");
    }

    @Test
    public void checkTempo() {
        assertEquals('T', scoreComponents[0].charAt(0));
    }

    @Test
    public void checkKey() {
        assertTrue(scoreComponents[1].contains("KEY:"));
        assertTrue(scoreComponents[1].contains("min"));
    }

    @Test
    public void checkVoice() {
        assertEquals("V0", scoreComponents[2] );
    }

    @Test
    public void checkInstrument() {
        assertEquals('I', scoreComponents[4].charAt(0));
        assertEquals('[', scoreComponents[4].charAt(1));
    }

    @Test
    public void checkVoices() {
        Boolean secondVoice = false;
        for(int i = 0; i < scoreComponents.length; i++) {
            if(scoreComponents[i].equals("V1")) {
                secondVoice = true;
            }
        }
        assertTrue(secondVoice);
    }

    @Test
    public void checkBassInstruments() {
        BassInstruments[] bass = BassInstruments.values();
        Boolean bassCorrect = false;
        for(int i = 0; i < bass.length; i++) {
            for(int j = 0; j < scoreComponents.length; j++) {
                String instrument = "I[" + bass[i] + "]";
                if(instrument.equals(scoreComponents[j])) {
                    bassCorrect = true;
                }
            }
        }
        assertTrue(bassCorrect);
    }

}
