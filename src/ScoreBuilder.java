import Genre.*;
import Mood.*;
import org.jfugue.pattern.Pattern;

public class ScoreBuilder {
    private static Pattern percussion = null;
    private static Score score;


    /**
     * This method is called from the front end servlet and initiates the music generation process
     * @param genre - genre selected by the user
     * @param mood - mood selected by the user
     * @return - the piece of music that has been generated
     */
    public static Pattern runGenerator(Genre genre, Mood mood) {
        score = new Score(genre, mood);
        setUpScore();
        setBassAndPercussion();
        score.updateScore();
        return convertTrack();
    }

    /**
     * initialises the score from the ScoreBuilder to the new Score class
     */
    private static void setUpScore() {
        score.initialiseScore();
    }

    /**
     * adds the bass and percussion from the ScoreBuilder into the Score
     */
    private static void setBassAndPercussion() {
        score.addBass();
        percussion = score.getPercussion();
    }

    /**
     * After the scores have been added, the final score is retrieved as a String. This method then
     * turns it into a single Pattern class to return to the servlet
     * @return Pattern containing the final score
     */
    private static Pattern convertTrack() {
        Pattern tempScore = new Pattern(score.getScore());
        Pattern finalScore = new Pattern();

        //if statement ensures the percussion has been assigned properly
        if(percussion != null) {
            finalScore = new Pattern(tempScore, percussion.repeat(10));
        }
        return finalScore;
    }

}
