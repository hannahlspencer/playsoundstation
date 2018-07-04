package Genre;

public class Horror implements Genre {
    @Override
    public String selectInstruments() {
        HorrorInstruments instrument =
                HorrorInstruments.values()[(int)(Math.random()*HorrorInstruments.values().length)];
        System.out.println(instrument);
        return "[" + instrument + "] ";
    }

    @Override
    public String setBassline(String score) {
        //need to get the key so know what notes can be used
        BassInstruments instrument =
                BassInstruments.values()[(int)(Math.random()*BassInstruments.values().length)];
        String melody = "";
        for(int i = 0; i < 12; i++) {
            String[] letters = {"A", "B", "C", "D", "E", "F", "G", "R"};
            String note = letters[(int) (Math.random() * letters.length)];
            melody += (note + "w ");
        }
        System.out.println("I[" + instrument + "] " + melody);
        return "I[" + instrument + "] " + melody;
    }
}
