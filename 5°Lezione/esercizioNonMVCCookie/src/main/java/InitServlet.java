import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index.html")
public class InitServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getCookies()==null) {
            response.sendRedirect("login.html");
        }
        else {
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("username")) {
                    request.setAttribute("username", cookie.getValue());
                    request.getRequestDispatcher("result.jsp").forward(request, response);
                    return;
                }
            }
            response.sendRedirect("login.html");
        }
    }
}
