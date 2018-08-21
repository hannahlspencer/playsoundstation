import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;
import org.jfugue.player.Player;

import javax.sound.midi.spi.MidiFileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreUtils {

    private static List availableNotes = new ArrayList<String>();
    private static List availableBassNotes = new ArrayList<String>();

    public static void initialise() {
        initialiseAvailableNotes();
        initialiseBassNotes();
    }

    private static void initialiseAvailableNotes() {
        availableNotes.add("A");
        availableNotes.add("B");
        availableNotes.add("C");
        availableNotes.add("D");
        availableNotes.add("E");
        availableNotes.add("F");
        availableNotes.add("G");
    }

    private static void initialiseBassNotes() {
        availableBassNotes.add("A3");
        availableBassNotes.add("B3");
        availableBassNotes.add("C3");
        availableBassNotes.add("D3");
        availableBassNotes.add("E3");
        availableBassNotes.add("F3");
        availableBassNotes.add("G3");
    }

    public static List getAvailableNotes() {
        return availableNotes;
    }

    public static List getAvailableBassNotes() {
        return availableBassNotes;
    }

    /**
     * Method that helps the makeNewMelody method by returning the representative note lengths so that bars
     * can be established ensuring that each line of melody is the same length
     * @param length - the note that has been selected
     * @return the numeric length of the note
     */
    public static double checkBar(String length) {
        switch(length) {
            case "w" :
                return 4;
            case "h" :
                return 2;
            case "q":
                return 1;
            case "i":
                return 0.5;
            default:
                return 0;
        }
    }

    /**
     * Method that chooses what note lengths are left that would suit the bar, and picks one at random
     * from the available lengths
     * @param barLength - how many beats are left in the current bar
     * @return a note length that is appropriate for the bar
     */
    public static String chooseNoteLength(double barLength) {
        double overspill = 4 - barLength;
        List adjustedNoteLengths = new ArrayList();
        if(overspill == 0.5) {
            adjustedNoteLengths.add("i");
        } else if(overspill > 0.5 && overspill < 2) {
            adjustedNoteLengths.add("q");
            adjustedNoteLengths.add("i");
        } else if(overspill >= 2 && overspill < 4) {
            adjustedNoteLengths.add("q");
            adjustedNoteLengths.add("i");
            adjustedNoteLengths.add("h");
        } else if(overspill == 4) {
            adjustedNoteLengths.add("q");
            adjustedNoteLengths.add("i");
            adjustedNoteLengths.add("h");
            adjustedNoteLengths.add("w");
        }
        return adjustedNoteLengths.get((int) (Math.random() * adjustedNoteLengths.size())).toString();
    }

    public static void main(String[] args) {
        Pattern firstLayer = new Pattern("T78 KEY:F#min  V1 I[FRETLESS_BASS] Rq Rq Rh | Ri Rh Ri Ri Ri | Rh C3h | E3w | Rh Ri Ri Ri Ri | Rh G3h | D3w | D3w | G3w | Rh G3h | KEY:Cmaj Rh Rh | Rh Ri Ri Rq | Rw | Rw | Rh F3h | Ri B3h Rq Ri | Rq Ri Ri Ri Rq Ri | F3w | C3w | D3h Rq Ri Ri |  KEY:F#min Rh Rh | C3h D3h | Rh Rh | D3w | D3w | Ri Rh Rq Ri | C3h Ri Ri Ri Ri | Rq Rh Ri Ri | Ri Ri Rq Rq Ri Ri | A3w | Ri Rh Ri Rq | Ri G3h Ri Ri Fi");
        Player player = new Player();


        //player.play(firstLayer);
        //Pattern secondLayer = new Pattern("T144 KEY:G#maj  V1 I[FRETLESS_BASS] Rw | B3i D3q Rq E3q F3i | G3i B3q C3i E3q G3q | Rh A3q E3q | A3q D3i Rq F3i A3q | Ri A3i G3q B3i D3q G3i | C3i D3i A3q G3q C3i B3i | C3i Rh E3i E3i A3i | F3q F3q C3i D3i G3i E3i | Rq D3q G3i D3q F3i | KEY:Dmin Rw | A3q C3i C3q A3q G3i | F3q Ri F3q F3q F3i | Rq D3i Ri G3i F3i F3i C3i | G3q Rq D3q E3q | B3q Ri A3q D3q B3i | Rw | F3i A3i E3i Ri A3q D3q | E3q C3i B3i Rq G3q | A3q E3q Ri C3i C3q |  KEY:G#maj D3i Ri A3q Ri G3q A3i | Rq Rh E3i F3i | Rq Rq B3q E3i C3i | D3q C3i A3i C3q F3i G3i | F3q G3q Rh | F3q Rq C3q A3i C3i | G3i G3i Rh G3q | C3q Rh B3q | Rq Ri Ri Rq G3q | F3i G3i A3i Ri D3q G3q | D3q B3i A3q D3i G3i C3i | Ri Rh D3q G3i");
       // player.play(secondLayer);
        //player.play(firstLayer, secondLayer);
//Pattern both = new Pattern(firstLayer, secondLayer);
        Pattern percussion = new Pattern("");

        //Pattern together = new Pattern(both, percussion);
        try {
            MidiFileManager.savePatternToMidi(firstLayer, new File("firstVoice.mid"));
            //MidiFileManager.savePatternToMidi(secondLayer, new File("updateScoreMelody.mid") );
//            MidiFileManager.savePatternToMidi((PatternProducer) both, new File("updateScoreTogether.mid") );
//            MidiFileManager.savePatternToMidi((PatternProducer) percussion, new File("percussion.mid") );
//            MidiFileManager.savePatternToMidi((PatternProducer) together, new File("final.mid") );




        } catch (Exception ex) {
            ex.getStackTrace();
        }
        //player.play(percussion);
        //player.play(firstLayer, secondLayer, percussion);
    }
}
