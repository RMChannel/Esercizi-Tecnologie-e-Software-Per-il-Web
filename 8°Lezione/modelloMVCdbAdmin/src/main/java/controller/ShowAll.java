package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showClients")
public class ShowAll extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        CustomerDAO cdao = new CustomerDAO();
        ArrayList<Customer> customers= (ArrayList<Customer>) cdao.doRetrieveAll();
        req.setAttribute("customers", customers);
        req.getRequestDispatcher("/WEB-INF/results/showAll.jsp").forward(req,res);
    }
}
