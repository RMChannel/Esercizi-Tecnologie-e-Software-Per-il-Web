package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import model.CustomerDAO;

import java.io.IOException;

@WebServlet("/UpdateCustomer")
public class EditClient extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO dao = new CustomerDAO();
        if(request.getParameter("button").equals("Modifica")) {
            Customer customer = dao.doRetrieveById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/WEB-INF/results/editCustomer.jsp").forward(request,response);
        }
        else if(request.getParameter("button").equals("Rimuovi dai preferiti")) {
            dao.setFavorite(false,Integer.parseInt(request.getParameter("id")));
            response.sendRedirect(request.getContextPath()+"/showClients?Mostra=Mostra/");
        }
        else {
            dao.setFavorite(true,Integer.parseInt(request.getParameter("id")));
            response.sendRedirect(request.getContextPath()+"/showClients?Mostra=Mostra");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO dao = new CustomerDAO();
        dao.editCustomer(request.getParameter("nome"),request.getParameter("cognome"),Double.parseDouble(request.getParameter("bilancio")),Integer.parseInt(request.getParameter("id")));
        request.setAttribute("customer", dao.doRetrieveById(Integer.parseInt(request.getParameter("id"))));
        request.getRequestDispatcher("/WEB-INF/results/confirmEdit.jsp").forward(request,response);
    }
}
