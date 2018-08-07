import org.junit.Test;
import Genre.*;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class GenreTests {
    Genre genre;

    @Test
    public void TestAction() {
        genre = new Action();
        String[] bassNoteLengths = { "q", "i" };
        List bass2 = Arrays.asList(bassNoteLengths);
        String[] instruments = {"ROCK_ORGAN", "OVERDRIVEN_GUITAR", "GUITAR_HARMONICS", "DISTORTION_GUITAR"};
        List instrumentList = Arrays.asList(instruments);
        assertEquals(bass2, Arrays.asList(genre.getBassNoteLengths()));
        assertEquals(instrumentList,Arrays.asList(genre.getInstruments()));
    }
    @Test
    public void TestHorror() {
        genre = new Horror();
        String[] bassNoteLengths = { "w"};
        List bass2 = Arrays.asList(bassNoteLengths);
        String[] instruments = {"VIOLIN", "VIOLA", "CELLO", "CHOIR_OOHS", "CHOIR_AAHS", "SYNTH_VOICE", "CRYSTAL","TUBULAR_BELLS",
                "MUSIC_BOX", "BREATH_NOISE", "METALLIC"};
        List instrumentList = Arrays.asList(instruments);
        assertEquals(bass2, Arrays.asList(genre.getBassNoteLengths()));
        assertEquals(instrumentList,Arrays.asList(genre.getInstruments()));
    }
    @Test
    public void TestPuzzler() {
        genre = new Puzzler();
        String[] bassNoteLengths = { "w", "h", "q", "i" };
        List bass2 = Arrays.asList(bassNoteLengths);
        String[] instruments = {"CHOIR", "CRYSTAL", "BOWED",  "SAWTOOTH", "ELECTRIC_JAZZ_GUITAR"};
        List instrumentList = Arrays.asList(instruments);
        assertEquals(bass2, Arrays.asList(genre.getBassNoteLengths()));
        assertEquals(instrumentList,Arrays.asList(genre.getInstruments()));
    }
    @Test
    public void TestRPG() {
        genre = new RPG();
        String[] bassNoteLengths = {  "w", "h" };
        List bass2 = Arrays.asList(bassNoteLengths);
        String[] instruments = {"VIOLIN", "VIOLA", "CELLO", "FLUTE", "OCARINA",
                "CLARINET", "ORCHESTRAL_STRINGS"};
        List instrumentList = Arrays.asList(instruments);
        assertEquals(bass2, Arrays.asList(genre.getBassNoteLengths()));
        assertEquals(instrumentList,Arrays.asList(genre.getInstruments()));
    }
    @Test
    public void TestSim() {
        genre = new Sim();
        String[] bassNoteLengths = { "w", "q", "h" };
        List bass2 = Arrays.asList(bassNoteLengths);
        String[] instruments = {"NEW_AGE", "SWEEP", "WARM", "POLY_SYNTH", "CHOIR",
                "BOWED", "METALLIC", "HALO", "SYNTH_BRASS_1", "SYNTH_BRASS_2"};
        List instrumentList = Arrays.asList(instruments);
        assertEquals(bass2, Arrays.asList(genre.getBassNoteLengths()));
        assertEquals(instrumentList,Arrays.asList(genre.getInstruments()));
    }
    @Test
    public void TestStrategy() {
        genre = new Strategy();
        String[] bassNoteLengths = {"w", "h"};
        List bass2 = Arrays.asList(bassNoteLengths);
        String[] instruments = {"TRUMPET", "MUTED_TRUMPET", "TUBA", "VIOLIN"};
        List instrumentList = Arrays.asList(instruments);
        assertEquals(bass2, Arrays.asList(genre.getBassNoteLengths()));
        assertEquals(instrumentList,Arrays.asList(genre.getInstruments()));
    }
}
