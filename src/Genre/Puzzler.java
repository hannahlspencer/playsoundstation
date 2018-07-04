package Genre;
public class Puzzler implements Genre {

    @Override
    public String selectInstruments() {
        //selects a random instrument from the preassigned instruments for the genre
        PuzzlerInstruments instrument =
                PuzzlerInstruments.values()[(int)(Math.random()*PuzzlerInstruments.values().length)];
        return "[" + instrument + "] ";
    }

    @Override
    public String setBassline(String key) {
        //need to get the key so know what notes can be used
        BassInstruments instrument =
                BassInstruments.values()[(int)(Math.random()*BassInstruments.values().length)];
        String melody = "";
        for(int i = 0; i < 12; i++) {
            String[] letters = {"A", "B", "C", "D", "E", "F", "G", "R"};
            String[] noteLengths = {"w", "q", "i", "h"};
            String note = letters[(int) (Math.random() * letters.length)];
            String length = noteLengths[(int) (Math.random() * noteLengths.length)];
            melody += (note + length + " ");
        }
        System.out.println("I[" + instrument + "] " + melody);
        return "I[" + instrument + "] " + melody;

    }
}
