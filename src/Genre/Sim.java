package Genre;

public class Sim implements Genre {
    @Override
    public String selectInstruments() {
        SimInstruments instrument =
                SimInstruments.values()[(int)(Math.random()*SimInstruments.values().length)];
        System.out.println(instrument);
        return "[" + instrument + "] ";
    }

    @Override
    public String setBassline(String score) {
        BassInstruments instrument =
                BassInstruments.values()[(int)(Math.random()*BassInstruments.values().length)];
        String melody = "";
        for(int i = 0; i < 12; i++) {
            String[] letters = {"A", "B", "C", "D", "E", "F", "G", "R"};
            String[] noteLengths = {"w", "q", "h"};
            String note = letters[(int) (Math.random() * letters.length)];
            String length = noteLengths[(int) (Math.random() * noteLengths.length)];
            melody += (note + length + " ");
        }
        System.out.println("I[" + instrument + "] " + melody);
        return "I[" + instrument + "] " + melody;
    }
}
