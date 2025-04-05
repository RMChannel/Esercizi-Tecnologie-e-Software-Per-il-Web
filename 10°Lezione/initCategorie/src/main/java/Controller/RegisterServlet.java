package Controller;

import Model.Utente;
import Model.UtenteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        UtenteDAO dao = new UtenteDAO();
        if(dao.doUserExists(req.getParameter("username"))) {
            req.setAttribute("error", "1");
            req.getRequestDispatcher("register.jsp").forward(req,res);
        }
        else if(dao.doEmailExists(req.getParameter("email"))) {
            req.setAttribute("error", "2");
            req.getRequestDispatcher("register.jsp").forward(req,res);
        }
        else {
            Utente u = new Utente();
            u.setUsername(req.getParameter("username"));
            u.setEmail(req.getParameter("email"));
            u.setPassword(req.getParameter("password"));
            u.setAdmin(false);
            dao.doSave(u);
            HttpSession session = req.getSession();
            session.setAttribute("username", u.getUsername());
            session.setAttribute("email", u.getEmail());
            req.getRequestDispatcher("index.html").forward(req,res);
        }
    }
}
