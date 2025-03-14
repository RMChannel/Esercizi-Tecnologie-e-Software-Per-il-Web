package Controller;

import Model.BeerExpert;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io. IOException;

@WebServlet("/processBeer")
public class ServletBeer extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String paramValue = req.getParameter("color");
        BeerExpert beerExpert =new BeerExpert(paramValue);
        req.setAttribute("beerExpert", beerExpert);
        RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/results/result.jsp");
        dispatcher.forward(req, res);
    }
}
