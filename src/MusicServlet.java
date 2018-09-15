import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import java.io.*;

@WebServlet("/MusicServlet")
public class MusicServlet extends HttpServlet {

    /**
     * Retrieves the user's set parameters and sends them into the adapter class (ScoreBuilder) to trigger the building
     * of the track relevant to those parameters
     * Sets the response headers as audio, and writes the Sequence returned from the ScoreBuilder as a Midi file
     * in the response
     * @param request user parameters
     * @param response response to user
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //retrieving selected genre and mood as Strings
        String genre = request.getParameter("genre");
        String mood = request.getParameter("mood");
        //number of bars that will be made when the music is generated
        int bars = Integer.parseInt(request.getParameter("bars"));
        int melodicLines = Integer.parseInt(request.getParameter("melody"));

        //if statement prevents any accidental nulls
        if(mood != null && genre != null) {
            //runs the ScoreBuilder and generates the piece of music that is then saved to song
            Sequence song = ScoreBuilder.runGenerator(genre, mood, bars, melodicLines);

            //HTTP responses set
            response.setContentType("audio/mid");
            response.addHeader("Content-disposition", "attachment; filename=song.mid");
            OutputStream responseOutputStream = response.getOutputStream();
            MidiSystem.write(song,1, responseOutputStream);
        }
    }
}
