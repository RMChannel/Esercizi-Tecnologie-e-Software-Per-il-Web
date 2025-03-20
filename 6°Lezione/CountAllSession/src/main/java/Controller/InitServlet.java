package Controller;

import Model.CountBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/index.html")
public class InitServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(CountBean.getCount() ==0){
            CountBean.addCount();
            request.getRequestDispatcher("firstTime.html").forward(request,response);
        }
        else {
            CountBean.addCount();
            request.setAttribute("count", CountBean.getCount());
            request.getRequestDispatcher("anotherTime.jsp").forward(request,response);
        }
    }
}