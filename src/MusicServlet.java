import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import Genre.*;
import Mood.*;
import java.io.PrintWriter;

@WebServlet("/MusicServlet")
public class MusicServlet extends HttpServlet {
    private String genre = "";
    private String mood = "";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        genre = request.getParameter("genre");
        mood = request.getParameter("mood");
        response.getWriter().write("<h2>Your genre is: " + genre + "</h2");
        //use reflection to instantiate the Genre?
        try {
            Class<?> x = Class.forName(genre);
            Class<?> y = Class.forName(mood);
            Genre b = (Genre) x.newInstance();
            Mood a = (Mood) y.newInstance();
            Score score = new Score(b, a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {


        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }

    public String getGenre() {
        return genre;
    }

    public String getMood() {
        return mood;
    }
}