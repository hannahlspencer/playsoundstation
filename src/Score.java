import Genre.*;
import Mood.*;
import Function.*;
import org.jfugue.rhythm.Rhythm;

public class Score {
    public Score(Genre g, Mood m) {
        genre = g;
        mood = m;
    }
    //this will increment with each voice added to the sound
    int counter = 0;
    String score;
    Genre genre;
    Mood mood;
    Function function;
    String instrument;
    String melody;
    String key;
    String tempo;
    Rhythm percussion;

    public void initialiseUtils() {
        GenreUtils.setGenre(genre);
        MoodUtils.setMood(mood);
    }

    public String startNewVoice() {
        String result = " V" + counter;
        counter++;
        return result;
    }

    public void setInstrument() {
        GenreUtils.setInstruments();
        instrument = " I[" + GenreUtils.getRandomInstrument() + "] ";
    }

    public String getInstrument() {
        return instrument;
    }

    public void setKey() {
        key = " KEY:" + MoodUtils.setKey();
    }

    public String getKey() {
        return key;
    }

    public void setTempo() {
        tempo = MoodUtils.decideTempo();
    }

    public void initialiseScore() {
        score = tempo + key + startNewVoice() + instrument;
    }

    public void addBass() {
        score = score + startNewVoice() + GenreUtils.setBassline(4);
    }
    public void getPercussion() {
        percussion = MoodUtils.addPercussion();
    }

    public void updateScore(String newMelody) {
        score = score + " V" + counter + instrument + " " + melody;
    }
}
