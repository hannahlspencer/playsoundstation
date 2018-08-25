import Genre.*;
import Mood.*;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Sequence;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ScoreBuilderTests {
    private String[] scoreComponents;
    private String[] scoreComponentsTwoMelody;
    private String[] scoreComponentsThreeMelody;
    private Score score;
    private Score scoreTwoMelody;
    private Score scoreThreeMelody;
    private String[] scoreArray;
    private String[] scoreTwoArray;
    private String[] scoreThreeArray;





    @Before
    public void initialise() {
        scoreComponents = ScoreBuilder.runGenerator("Strategy", "Gloomy", 8, 1).toString().split(" ");
        score = ScoreBuilder.getScore();
        scoreArray = score.getScore().split(" ");
        scoreComponentsTwoMelody = ScoreBuilder.runGenerator("Strategy", "Gloomy", 8, 2).toString().split(" ");
        scoreTwoMelody = ScoreBuilder.getScore();
        scoreTwoArray = scoreTwoMelody.getScore().split(" ");
        scoreComponentsThreeMelody = ScoreBuilder.runGenerator("Strategy", "Gloomy", 8, 3).toString().split(" ");
        scoreThreeMelody = ScoreBuilder.getScore();
        scoreThreeArray = scoreThreeMelody.getScore().split(" ");

    }

    @Test
    public void checkTempo() {
        assertEquals('T', scoreArray[0].charAt(0));

    }

    @Test
    public void checkTempoTwo() {
        assertEquals('T', scoreTwoArray[0].charAt(0));
    }

    @Test
    public void checkTempoThree() {
        assertEquals('T', scoreThreeArray[0].charAt(0));
    }

    @Test
    public void checkKey() {
        assertTrue(scoreArray[1].contains("KEY:"));
        assertTrue(scoreArray[1].contains("min"));
    }

    @Test
    public void checkKeyTwo() {
        assertTrue(scoreTwoArray[1].contains("KEY:"));
        assertTrue(scoreTwoArray[1].contains("min"));
    }

    @Test
    public void checkKeyThree() {
        assertTrue(scoreThreeArray[1].contains("KEY:"));
        assertTrue(scoreThreeArray[1].contains("min"));
    }

    @Test
    public void checkVoice() {
        assertEquals("V0", scoreArray[2] );
    }

    @Test
    public void checkFirstVoiceTwo() {
        assertEquals("V0", scoreTwoArray[2] );
    }

    @Test
    public void checkFirstVoiceThree() {
        assertEquals("V0", scoreThreeArray[2] );
    }

    @Test
    public void checkSecondVoiceTwo() {
        assertTrue(Arrays.asList(scoreTwoArray).contains("V1"));
    }

    @Test
    public void checkSecondVoiceThree() {
        assertTrue(Arrays.asList(scoreThreeArray).contains("V1"));
    }

    @Test
    public void checkNoThirdVoiceOne() {
        assertFalse(Arrays.asList(scoreArray).contains("V2"));
    }

    @Test
    public void checkThirdVoiceThree() {
        assertTrue(Arrays.asList(scoreThreeArray).contains("V2"));
    }
    @Test
    public void checkInstrument() {
        assertEquals('I', scoreArray[3].charAt(0));
        assertEquals('[', scoreArray[3].charAt(1));
    }

    @Test
    public void checkInstrumentTwo() {
        assertEquals('I', scoreTwoArray[3].charAt(0));
        assertEquals('[', scoreTwoArray[3].charAt(1));
    }

    @Test
    public void checkInstrumentThree() {
        assertEquals('I', scoreThreeArray[3].charAt(0));
        assertEquals('[', scoreThreeArray[3].charAt(1));
    }

    @Test
    public void checkVoices() {
        Boolean secondVoice = false;
        for(int i = 0; i < scoreArray.length; i++) {
            if(scoreArray[i].equals("V1")) {
                secondVoice = true;
            }
        }
        assertTrue(secondVoice);
    }

    @Test
    public void checkVoicesTwo() {
        Boolean secondVoice = false;
        for(int i = 0; i < scoreTwoArray.length; i++) {
            if(scoreTwoArray[i].equals("V1")) {
                secondVoice = true;
            }
        }
        assertTrue(secondVoice);
    }

    @Test
    public void checkVoicesThree() {
        Boolean secondVoice = false;
        Boolean thirdVoice = false;
        for(int i = 0; i < scoreThreeArray.length; i++) {
            if(scoreThreeArray[i].equals("V1")) {
                secondVoice = true;
            }
            if(scoreThreeArray[i].equals("V2")) {
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
            for(int j = 0; j < scoreArray.length; j++) {
                String instrument = "I[" + bass[i] + "]";
                if(instrument.equals(scoreArray[j])) {
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
            for(int j = 0; j < scoreTwoArray.length; j++) {
                String instrument = "I[" + bass[i] + "]";
                if(instrument.equals(scoreTwoArray[j])) {
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
            for(int j = 0; j < scoreThreeArray.length; j++) {
                String instrument = "I[" + bass[i] + "]";
                if(instrument.equals(scoreThreeArray[j])) {
                    bassCorrect = true;
                }
            }
        }
        assertTrue(bassCorrect);
    }

    @Test
    public void checkInterpretGenre() {
        Genre action = ScoreBuilder.interpretGenre("Action");
        assertTrue(action instanceof Action);
        Genre horror = ScoreBuilder.interpretGenre("Horror");
        assertTrue(horror instanceof Horror);
        Genre puzzler = ScoreBuilder.interpretGenre("Puzzler");
        assertTrue(puzzler instanceof Puzzler);
        Genre rpg = ScoreBuilder.interpretGenre("RPG");
        assertTrue(rpg instanceof RPG);
        Genre sim = ScoreBuilder.interpretGenre("Sim");
        assertTrue(sim instanceof Sim);
        Genre strategy = ScoreBuilder.interpretGenre("Strategy");
        assertTrue(strategy instanceof Strategy);
    }

    @Test
    public void checkInterpretMood() {
        Mood downbeat = ScoreBuilder.interpretMood("Downbeat");
        assertTrue(downbeat instanceof Downbeat);
        Mood dreamy = ScoreBuilder.interpretMood("Dreamy");
        assertTrue(dreamy instanceof Dreamy);
        Mood excited = ScoreBuilder.interpretMood("Excited");
        assertTrue(excited instanceof Excited);
        Mood gloomy = ScoreBuilder.interpretMood("Gloomy");
        assertTrue(gloomy instanceof Gloomy);
        Mood scary = ScoreBuilder.interpretMood("Scary");
        assertTrue(scary instanceof Scary);
        Mood upbeat = ScoreBuilder.interpretMood("Upbeat");
        assertTrue(upbeat instanceof Upbeat);
    }

}
