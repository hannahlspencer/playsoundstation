package Genre;

public class RPG implements Genre {
    @Override
    public String selectInstruments() {
        RPGInstruments instrument =
                RPGInstruments.values()[(int)(Math.random()*RPGInstruments.values().length)];
        return "[" + instrument + "] ";
    }

    @Override
    public String setBassline(String score) {
        BassInstruments instrument =
                BassInstruments.values()[(int)(Math.random()*BassInstruments.values().length)];
        String melody = "";
        for(int i = 0; i < 24; i++) {
            String[] letters = {"A", "B", "C", "D", "E", "F", "G", "R"};
            String[] noteLengths = {"w", "h"};
            String note = letters[(int) (Math.random() * letters.length)];
            String length = noteLengths[(int) (Math.random() * noteLengths.length)];
            melody += (note + length + " ");
        }
        System.out.println("I[" + instrument + "] " + melody);
        return "I[" + instrument + "] " + melody;
    }
}
