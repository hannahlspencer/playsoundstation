package Genre;

public class Action implements Genre {
    @Override
    public String selectInstruments() {
        ActionInstruments instrument =
                ActionInstruments.values()[(int)(Math.random()*ActionInstruments.values().length)];
        return "[" + instrument + "] ";
    }

    @Override
    public String setBassline(String score) {
        //need to get the key so know what notes can be used
        BassInstruments instrument =
                BassInstruments.values()[(int)(Math.random()*BassInstruments.values().length)];
        String melody = "";
        for(int i = 0; i < 24; i++) {
            String[] letters = {"A", "B", "C", "D", "E", "F", "G", "R"};
            //note lengths for bass are shorter to make the overall feel more exciting
            String[] noteLengths = {"q", "i"};
            String note = letters[(int) (Math.random() * letters.length)];
            String length = noteLengths[(int) (Math.random() * noteLengths.length)];
            melody += (note + length + " ");
        }
        System.out.println("I[" + instrument + "] " + melody);
        return "I[" + instrument + "] " + melody;
    }
}
