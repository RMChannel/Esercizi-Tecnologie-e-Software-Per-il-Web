package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

@WebServlet("/index.html")
public class InitServlet extends HttpServlet {
    private int count=0;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(count==0){
            count++;
            request.getRequestDispatcher("firstTime.html").forward(request,response);
        }
        else {
            count++;
            request.setAttribute("count", count);
            request.getRequestDispatcher("anotherTime.jsp").forward(request,response);
        }
    }
}