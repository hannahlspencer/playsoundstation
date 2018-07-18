import Genre.*;
import Mood.*;
import Function.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.rhythm.Rhythm;

public class Score {
    public Score(Genre g, Mood m) {
        genre = g;
        mood = m;
        GenreUtils.setGenre(g);
        MoodUtils.setMood(m);
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
    Pattern percussion;


    public String startNewVoice() {
        String result = " V" + counter + " ";
        counter++;
        return result;
    }

    public String getScore() {
        return score;
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
        score = tempo + key + startNewVoice() + instrument + makeNewMelody();
    }

    private String makeNewMelody() {
        melody = "";
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "R"};
        String[] noteLengths = { "w", "h", "q", "i" };
        for (int i = 0; i < 16; i++) {
            String note = letters[(int) (Math.random() * letters.length)];
            String length = noteLengths[(int) (Math.random() * noteLengths.length)];

            melody += (note + length + " ");
        }
        return melody;
    }

    public void addBass() {
        String bassline = GenreUtils.setBassline(16);
        System.out.println("We have no bassline");
        if(bassline != "") {
            System.out.println("We have a bassline!");
            score = score + startNewVoice() + bassline;
        }
    }
    public void setPercussion() {
        percussion = MoodUtils.addPercussion();
    }

    public Pattern getPercussion() {
        return percussion;
    }

    public void updateScore() {
        setInstrument();

        score = score + startNewVoice() + instrument + makeNewMelody();
    }
}
