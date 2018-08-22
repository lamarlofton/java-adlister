import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet(name = "PinkcolorServlet", urlPatterns = "/color")
    public class PinkcolorServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.getRequestDispatcher("/color.jsp");
        }
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("color");
            request.setAttribute("color", name);
            request.getRequestDispatcher("/Favcolor.jsp").forward(request, response);
        }
    }

