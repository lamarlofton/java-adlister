import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean isLoggedIn = (Boolean)request.getSession().getAttribute("isLoggedIn");

        if(isLoggedIn != null) {
            if (isLoggedIn) {
                response.sendRedirect("/profile");
                return;
            }
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {
            request.getSession().setAttribute("user", username );
            response.sendRedirect("/profile");

        } else {
            request.getSession().setAttribute("isLoggedIn", false );
            response.sendRedirect("/login");
        }
    }
    
    
    }
