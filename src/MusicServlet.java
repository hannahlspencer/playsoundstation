import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import java.io.*;


import Genre.*;
import Mood.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

@WebServlet("/MusicServlet")
public class MusicServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //retrieving selected genre and mood as Strings
        String genre = request.getParameter("genre");
        String mood = request.getParameter("mood");
        //number of bars that will be made when the music is generated
        int bars = Integer.parseInt(request.getParameter("bars"));
        int melodicLines = Integer.parseInt(request.getParameter("melody"));
        //turning String selections into their relevant classes
        Genre genreClass = interpretGenre(genre);
        Mood moodClass = interpretMood(mood);

        //if statement prevents any accidental nulls
        if(mood != null && genre != null) {
            //runs the ScoreBuilder and generates the piece of music that is then saved to song
            Pattern song = ScoreBuilder.runGenerator(genreClass, moodClass, bars, melodicLines);

            //the Pattern version of the song is then turned into a Sequence for download
            Player player = new Player();
            Sequence finalTrack = player.getSequence(song);

            //HTTP responses set
            response.setContentType("audio/mid");
            response.addHeader("Content-disposition", "attachment; filename=song.mid");
            OutputStream responseOutputStream = response.getOutputStream();
            MidiSystem.write(finalTrack,1, responseOutputStream);
        }
    }


    /**
     * This method converts the String type selection that the user makes for Genre into the corresponding
     * Genre class
     * @param genre as inputted by the user
     * @return the Genre class that matches the genre selection made by the user
     */
    private Genre interpretGenre(String genre) {
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
     * This method converts the String type selection that the user makes for Mood into the corresponding
     * Mood class
     * @param mood as inputted by the user
     * @return the Mood class that matches the genre selection made by the user
     */
    private Mood interpretMood(String mood) {
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

}