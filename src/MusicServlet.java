import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import java.io.*;


import Genre.*;
import Mood.*;
import com.sun.media.sound.WaveFileWriter;
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

        //if statement prevents any accidental nulls
        if(mood != null && genre != null) {
            //runs the ScoreBuilder and generates the piece of music that is then saved to song
            Sequence song = ScoreBuilder.runGenerator(genre, mood, bars, melodicLines);

            //HTTP responses set
            response.setContentType("audio/mid");
            response.addHeader("Content-disposition", "attachment; filename=song.mid");
            OutputStream responseOutputStream = response.getOutputStream();
            MidiSystem.write(song,1, responseOutputStream); //currently being used

            /**
             * Ccould be used
             * https://stackoverflow.com/questions/3297749/java-reading-manipulating-and-writing-wav-files
            InputStream in = new InputStream() {
                @Override
                public int read() throws IOException {
                    song;
                }
            }
            WaveFileWriter writer = new WaveFileWriter();
            writer.write(song, AudioFileFormat.Type.WAVE, responseOutputStream);
             **/
        }
    }


}