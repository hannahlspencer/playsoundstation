import Genre.*;
import Mood.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

import javax.sound.midi.Sequence;

public class ScoreBuilder {
    private static Pattern percussion = null;
    private static Score score;


    /**
     * This method is called from the front end servlet and initiates the music generation process
     * @param genre - genre selected by the user
     * @param mood - mood selected by the user
     * @param bars - the number of bars the piece will have
     * @return - the piece of music that has been generated
     */
    public static Sequence runGenerator(String genre, String mood, int bars, int melodicLines) {
        Mood moodClass = interpretMood(mood);
        Genre genreClass = interpretGenre(genre);
        score = new Score(genreClass, moodClass, bars);

        //adds instrumentation, key, and first melodic line
        //removes 1 from melodicLines as the first melodic line is done
        setUpScore();
        int linesLeft = melodicLines - 1;

        //if the user has selected more than one melodic line, these are added with the updateScore method
        for(int i = 0; i < linesLeft; i++) {
            score.updateScore();
        }
        setBassAndPercussion();

        return convertTrack();
    }

    /**
     * This method converts the String type selection that the user makes for Mood into the corresponding
     * Mood class
     * @param mood as inputted by the user
     * @return the Mood class that matches the genre selection made by the user
     */
    public static Mood interpretMood(String mood) {
        String sMood = "Mood." + mood;
        Mood moodSelected = null;
        try {
            Class<?> reflectMood = Class.forName(sMood);
            moodSelected = (Mood) reflectMood.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Class wasn't found!");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("There has been an Illegal Access Error");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("There has been an Instantiation Exception Error");
            e.printStackTrace();
        }
        return moodSelected;
    }

    /**
     * This method converts the String type selection that the user makes for Genre into the corresponding
     * Genre class
     * @param genre as inputted by the user
     * @return the Genre class that matches the genre selection made by the user
     */
    public static Genre interpretGenre(String genre) {
        String sGenre = "Genre." + genre;
        Genre genreSelected = null;
        try {
            Class<?> reflectGenre = Class.forName(sGenre);
            genreSelected = (Genre) reflectGenre.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Class wasn't found!");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("There has been an Illegal Access Error");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("There has been an Instantiation Exception Error");
            e.printStackTrace();
        }
        return genreSelected;
    }

    /**
     * returns score built so far for testing purposes
     * @return Score of the score representation so far
     */
    public static Score getScore() {
        return score;
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
     * After the scores have been added, the final score is retrieved as two Patterns. This method then
     * turns it into a single Sequence class to return to the servlet
     * @return Sequence containing the final score
     */
    private static Sequence convertTrack() {
        Pattern tempScore = new Pattern(score.getScore());
        Pattern finalScore = new Pattern();
        //if statement ensures the percussion has been assigned properly
        if(percussion != null) {
            finalScore = new Pattern(tempScore, percussion);
        }
        Player player = new Player();
        return player.getSequence(finalScore);
    }

}
