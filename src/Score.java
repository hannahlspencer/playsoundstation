import Genre.*;
import Mood.*;
import org.jfugue.pattern.Pattern;

public class Score implements ScoreInterface {
    public Score(Genre genre, Mood mood) {
        /*
         * The score class itself doesn't need to know the mood and genre, so the constructor passes the knowledge of
         * mood and genre over to the Utils classes and uses those classes directly
         */
        GenreUtils.setGenre(genre);
        MoodUtils.setMood(mood);
    }
    //this will increment with each voice added to the sound
    private int counter = 0;
    //holds the overall score so far
    private String score;

    public int getCounter() {
        return counter;
    }

    @Override
    public String startNewVoice() {
        String result = " V" + counter + " ";
        counter++;
        return result;
    }

    @Override
    public String getScore() {
        return score;
    }

    @Override
    public String getInstrument() {
        return " I[" + GenreUtils.getRandomInstrument() + "] ";
    }

    @Override
    public String getKey() {
        return " KEY:" + MoodUtils.setKey();
    }


    @Override
    public String getTempo() {
        return MoodUtils.decideTempo();
    }

    @Override
    public void initialiseScore() {
        score = getTempo() + getKey() + startNewVoice() + getInstrument() + makeNewMelody();
    }

    @Override
    public String makeNewMelody() {
        String melody = "";
        //These String arrays hold the possible note pitches and lengths that can be used for the melody
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "R"};
        String[] noteLengths = { "w", "h", "q", "i" };

        //the for loop selects 16 notes from the pitches and lengths, puts them together and adds them to the melody
        for (int i = 0; i < 16; i++) {
            String note = letters[(int) (Math.random() * letters.length)];
            String length = noteLengths[(int) (Math.random() * noteLengths.length)];
            melody += (note + length + " ");
        }
        return melody;
    }

    @Override
    public void addBass() {
        String bassline = GenreUtils.setBassline(16);
        if(!bassline.equals("")) {
            score = score + startNewVoice() + bassline;
        }
    }
    public Pattern getPercussion() {
        return MoodUtils.addPercussion();
    }

    public void updateScore() {
        //calling setInstrument selects a different random instrument for the next voice
        score = score + startNewVoice() + getInstrument() + makeNewMelody();
    }
}
