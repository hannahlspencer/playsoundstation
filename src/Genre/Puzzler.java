package Genre;
public class Puzzler implements Genre {

    @Override
    public String selectInstruments() {
        //selects a random instrument from the preassigned instruments for the genre
        PuzzlerInstruments instrument =
                PuzzlerInstruments.values()[(int)(Math.random()*PuzzlerInstruments.values().length)];
        return "[" + instrument + "] ";
    }

//    @Override
//    public String setBassline(int numNotes) { not sure how to deal with number of notes yet
//            String[] noteLengths = {"w", "q", "i", "h"};
//           return GenreUtils.setBassline(noteLengths, numNotes);
//    }#
    @Override
    public String setBassline(String score) {
        return "x";
    }
}
