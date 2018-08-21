import Genre.*;
import Mood.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ScoreBuilderTests {
    private String[] scoreComponents;
    private String[] scoreComponentsTwoMelody;
    private String[] scoreComponentsThreeMelody;

    @Before
    public void initialise() {
        scoreComponents = ScoreBuilder.runGenerator("Strategy", "Gloomy", 8, 1).toString().split(" ");
        scoreComponentsTwoMelody = ScoreBuilder.runGenerator("Strategy", "Gloomy", 8, 2).toString().split(" ");
        scoreComponentsThreeMelody = ScoreBuilder.runGenerator("Strategy", "Gloomy", 8, 3).toString().split(" ");
        System.out.println("Score components: " + scoreComponents.toString());
    }

    @Test
    public void checkTempo() {
        assertEquals('T', scoreComponents[0].charAt(0));
    }

    @Test
    public void checkTempoTwo() {
        assertEquals('T', scoreComponentsTwoMelody[0].charAt(0));
    }

    @Test
    public void checkTempoThree() {
        assertEquals('T', scoreComponentsThreeMelody[0].charAt(0));
    }

    @Test
    public void checkKey() {
        assertTrue(scoreComponents[1].contains("KEY:"));
        assertTrue(scoreComponents[1].contains("min"));
    }

    @Test
    public void checkKeyTwo() {
        assertTrue(scoreComponentsTwoMelody[1].contains("KEY:"));
        assertTrue(scoreComponentsTwoMelody[1].contains("min"));
    }

    @Test
    public void checkKeyThree() {
        assertTrue(scoreComponentsThreeMelody[1].contains("KEY:"));
        assertTrue(scoreComponentsThreeMelody[1].contains("min"));
    }

    @Test
    public void checkVoice() {
        assertEquals("V0", scoreComponents[2] );
    }

    @Test
    public void checkFirstVoiceTwo() {
        assertEquals("V0", scoreComponentsTwoMelody[2] );
    }

    @Test
    public void checkFirstVoiceThree() {
        assertEquals("V0", scoreComponentsThreeMelody[2] );
    }

    @Test
    public void checkSecondVoiceTwo() {
        assertTrue(Arrays.asList(scoreComponentsTwoMelody).contains("V1"));
    }

    @Test
    public void checkSecondVoiceThree() {
        assertTrue(Arrays.asList(scoreComponentsThreeMelody).contains("V1"));
    }

    @Test
    public void checkThirdVoiceThree() {
        assertTrue(Arrays.asList(scoreComponentsThreeMelody).contains("V2"));
    }

    @Test
    public void checkInstrument() {
        assertEquals('I', scoreComponents[3].charAt(0));
        assertEquals('[', scoreComponents[3].charAt(1));
    }

    @Test
    public void checkInstrumentTwo() {
        assertEquals('I', scoreComponentsTwoMelody[3].charAt(0));
        assertEquals('[', scoreComponentsTwoMelody[3].charAt(1));
    }

    @Test
    public void checkInstrumentThree() {
        assertEquals('I', scoreComponentsThreeMelody[3].charAt(0));
        assertEquals('[', scoreComponentsThreeMelody[3].charAt(1));
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
    public void checkVoicesTwo() {
        Boolean secondVoice = false;
        for(int i = 0; i < scoreComponentsTwoMelody.length; i++) {
            if(scoreComponentsTwoMelody[i].equals("V1")) {
                secondVoice = true;
            }
        }
        assertTrue(secondVoice);
    }

    @Test
    public void checkVoicesThree() {
        Boolean secondVoice = false;
        Boolean thirdVoice = false;
        for(int i = 0; i < scoreComponentsThreeMelody.length; i++) {
            if(scoreComponentsThreeMelody[i].equals("V1")) {
                secondVoice = true;
            }
            if(scoreComponentsThreeMelody[i].equals("V2")) {
                thirdVoice = true;
            }
        }
        assertTrue(secondVoice);
        assertTrue(thirdVoice);
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

    @Test
    public void checkBassInstrumentsTwo() {
        BassInstruments[] bass = BassInstruments.values();
        Boolean bassCorrect = false;
        for(int i = 0; i < bass.length; i++) {
            for(int j = 0; j < scoreComponentsTwoMelody.length; j++) {
                String instrument = "I[" + bass[i] + "]";
                if(instrument.equals(scoreComponentsTwoMelody[j])) {
                    bassCorrect = true;
                }
            }
        }
        assertTrue(bassCorrect);
    }

    @Test
    public void checkBassInstrumentsThree() {
        BassInstruments[] bass = BassInstruments.values();
        Boolean bassCorrect = false;
        for(int i = 0; i < bass.length; i++) {
            for(int j = 0; j < scoreComponentsThreeMelody.length; j++) {
                String instrument = "I[" + bass[i] + "]";
                if(instrument.equals(scoreComponentsThreeMelody[j])) {
                    bassCorrect = true;
                }
            }
        }
        assertTrue(bassCorrect);
    }

}
