package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/index.html")
public class InitServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies=request.getCookies();
        if(cookies==null) {
            request.getRequestDispatcher("firstTime").forward(request,response);
        }
        else {
            for(Cookie cookie:cookies) {
                if(cookie.getName().equals("count")) {
                    cookie.setValue(Integer.toString(Integer.parseInt(cookie.getValue())+1));
                    cookie.setMaxAge(20*20*64);
                    response.addCookie(cookie);
                    request.setAttribute("count", Integer.parseInt(cookie.getValue()));
                    request.getRequestDispatcher("anotherTime.jsp").forward(request,response);
                    return;
                }
            }
        }
    }
}