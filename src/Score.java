import Genre.*;
public class Score {
    //this will increment with each voice added to the sound
    int counter = 0;
    String score;
    Genre genre;
    String instrument;
    String melody;
    String key;
    String tempo;




    public void setInstrument() {
        GenreUtils.getInstruments();
        instrument = GenreUtils.getRandomInstrument();
    }

    public void initialiseScore() {
        score = tempo + " KEY:" + key;
    }

    public void updateScore(String newMelody) {
        score = score + " V" + counter + " I" + instrument + " " + melody;
    }
}
