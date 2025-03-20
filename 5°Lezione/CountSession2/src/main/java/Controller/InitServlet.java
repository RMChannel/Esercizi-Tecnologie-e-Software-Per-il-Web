package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

@WebServlet("/index.html")
public class InitServlet extends HttpServlet {
    private Dictionary<String,Integer> dict=new Hashtable<String,Integer>();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session==null) {
            session=request.getSession(true);
            dict.put(session.getId(),1);
            request.getRequestDispatcher("firstTime.html").forward(request,response);
        }
        else {
            int count=dict.get(session.getId())+1;
            dict.put(session.getId(),count);
            request.setAttribute("count", count);
            request.getRequestDispatcher("anotherTime.jsp").forward(request,response);
        }
    }
}