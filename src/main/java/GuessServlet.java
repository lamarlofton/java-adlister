import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "GuessServlet", urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {
    private static int correctNumber = getRandom();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getRequestDispatcher("/guess.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("guess");
        request.setAttribute("correctNumber", correctNumber);
        request.getRequestDispatcher("/guessgame.jsp").forward(request, response);
    }

    private static int getRandom(){
        Random rand = new Random();
        int n = rand.nextInt(100) +1;
        return n;
    }
}

