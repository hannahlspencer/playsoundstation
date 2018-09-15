package Genre;

public class GenreUtils {

    private static Genre genreClass;

    /**
     * Takes the genre of the piece of music being built and saves it so that other
     * methods can change what they're doing based on the information within that specific genre class
     * @param genre - the Genre subclass that is being used
     */
    public static void setGenre(Genre genre) {
        genreClass = genre;
    }

    /**
     *
     * @return the class of the Genre being used
     */
    public static Genre getGenre() {
        return genreClass;
    }


    /**
     * Retrieves the list of available instruments from the Genre class and selects one at random to
     * use for the line of melody being considered
     * @return random instrument as a String to use in a String of melody
     */

    public static String getRandomInstrument() {
        String[] instruments = genreClass.getInstruments();
        return instruments[(int) (Math.random()*instruments.length)];
    }



    /**
     *  Selects a random Bass instrument to use for the bassline of the piece of music,
     *  checks if it's appropriate to have a bassline
     * @return String that contains the bass instrument or an empty String if no bass is to be used
     */
    public static String setBassInstrument() {
        //retrieves a random instrument from BassInstruments enum
        BassInstruments instrument =
                BassInstruments.values()[(int)(Math.random()*BassInstruments.values().length)];

        //puzzlers and horror games don't always require a bassline as both often use minimalistic tones
        //the chance variable and if statement ensures that both only have a bassline 50% of the time
        int chance = (int) Math.ceil(Math.random() * 2);
        if(((genreClass instanceof Horror) || (genreClass instanceof Puzzler)) && (chance == 1)){
            return "";
        } else {
            return "I[" + instrument + "] ";
        }
    }

    public static String[] getBassNotes() {
        return genreClass.getBassNoteLengths();
    }
}

