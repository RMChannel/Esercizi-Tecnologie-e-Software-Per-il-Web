package Controller;

import Model.HeaderBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/index.html")
public class ServletRequestHeaders extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<String> headerNames = Collections.list(request.getHeaderNames());
        List<String> headerValues = new ArrayList<String>();
        HeaderBean headerBean = new HeaderBean();
        headerBean.setHeaderNames(headerNames);
        for (String headerName : headerNames) {
            headerValues.add(request.getHeader(headerName));
        }
        headerBean.setHeaderValues(headerValues);
        request.setAttribute("headers", headerBean);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/showHeaders.jsp");
        dispatcher.forward(request, response);
    }
}
