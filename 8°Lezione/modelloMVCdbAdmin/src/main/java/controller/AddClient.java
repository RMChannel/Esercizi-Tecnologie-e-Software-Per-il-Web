package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

@WebServlet("/registration")
public class AddClient extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer=new Customer();
        customer.setFirstName(request.getParameter("nome"));
        customer.setLastName(request.getParameter("cognome"));
        customer.setBalance(Double.parseDouble(request.getParameter("bilancio")));
        CustomerDAO dao=new CustomerDAO();
        request.setAttribute("nome",request.getParameter("nome"));
        request.setAttribute("cognome",request.getParameter("cognome"));
        dao.doSave(customer);
        request.getRequestDispatcher("/WEB-INF/results/clientAdded.jsp").forward(request,response);
    }
}
