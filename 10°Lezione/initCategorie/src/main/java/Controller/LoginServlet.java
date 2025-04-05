package Controller;

import Model.Utente;
import Model.UtenteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UtenteDAO utenteDAO = new UtenteDAO();
        Utente utente=utenteDAO.doRetrieveByUsernamePassword(username, password);
        if(utente==null) {
            req.setAttribute("error", "error");
            req.getRequestDispatcher("login.jsp").forward(req,res);
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("email", utente.getEmail());
            res.sendRedirect("index.html");
        }
    }
}
