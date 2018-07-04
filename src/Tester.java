import Genre.Puzzler;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;
import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;
import org.jfugue.theory.ChordProgression;
import org.jfugue.tools.GetInstrumentsUsedTool;
import Mood.Happy;
import Mood.Mood;
import Genre.*;
import javax.sound.midi.Instrument;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import Functions.*;
public class Tester {
    public static void main(String[] args) {
         Player player = new Player();
//        //selecting a random instrument
//
//        List<String> notes = new ArrayList<String>();
//        notes.add("D#dim");
//        notes.add("Emaj");
//        notes.add("C#min");
//        notes.add("Amaj");
//        notes.add("G#min");
//        notes.add("Bmaj");
//        notes.add("F#min");
//
//        for(int i = 0; i < 10; i++) {
//            Genre.SynthInstruments x = Genre.SynthInstruments.values()[(int)(Math.random()*Genre.SynthInstruments.values().length)];
//            Random r = new Random();
//            int y = r.nextInt(7);
//            System.out.println("T120 V0 I[" + x + "]" + notes.get(y));
//            player.play("T220 V0 I[CHOIR_AAHS] C#min F#min Bmaj A B D E C#");
//
//        }
//      Pattern p1 = new Pattern("T100 V0 I[Violin] D5h E5h | A5h Bb5h | C#5h Rq A5q | A5q Ab5h | G5q G5q");
        Genre x = new Action();
//
//        System.out.println(x.getClass());
//        Pattern p2 = new Pattern("V0 I" + x.selectInstruments() + "D6majq F5majq A5majq D6q | C#6i D6i E6i F6i G6i F6i E6i D6i | " +
//             "E6i A5i E6i G6i F6i E6i D6i C#6i | " +
//                "B5i C#6i D6i F6i E6i D6i C#6i B5i | A5i Bb5i");
//        Pattern p1 = new Pattern(("V1 " + x.setBassline("A")));
//        //player.play(p2);
//        Pattern test = new Pattern("T100 KEY:Amin " + p2);
//        System.out.println(test);
//        player.play(test, p1);
        GenreUtils p = new GenreUtils();


        player.play("T100 KEY:Ebmaj V0 I" + p.getInstrument(x) + " C D E F G A B");
//        try {
//            MidiFileManager.savePatternToMidi((PatternProducer) p1, new File("Test.midi"));
//        } catch (Exception ex) {
//            ex.getStackTrace();
//        }
//        //player.play(p1, p2);
//        ChordProgression cp = new ChordProgression("I IV V I");
//        Rhythm rhythm = new Rhythm()
//                .addLayer("O..oO...O..oOO..")
//                .addLayer("..S...S...S...S.")
//                .addLayer("````````````````");
//        player.play(cp.setKey("BMIN"), rhythm);
       // player.play("T100 KEY:A V0 I[Violin] C D E F G A B");


    }
}

