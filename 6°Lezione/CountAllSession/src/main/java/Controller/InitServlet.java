package Controller;

import Model.CountBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/index.html")
public class InitServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CountBean countBean = (CountBean) getServletContext().getAttribute("CountBean");
        if(countBean == null) {
            getServletContext().setAttribute("CountBean",new CountBean());
            request.getRequestDispatcher("firstTime.html").forward(request,response);
        }
        else {
            countBean.addCount();
            request.setAttribute("count", countBean.getCount());
            request.getRequestDispatcher("anotherTime.jsp").forward(request,response);
        }
    }
}