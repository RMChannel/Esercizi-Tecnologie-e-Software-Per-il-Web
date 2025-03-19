import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Cookie cookie=new Cookie("username",username);
        Cookie cookie2=new Cookie("password",password);
        request.setAttribute("username",username);
        response.addCookie(cookie);
        response.addCookie(cookie2);
        RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
        rd.forward(request,response);
    }
}
