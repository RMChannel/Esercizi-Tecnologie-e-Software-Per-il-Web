package Controller;

import Model.Categoria;
import Model.CategoriaDAO;
import Model.Prodotto;
import Model.ProdottoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/index.html")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        CategoriaDAO cdao = new CategoriaDAO();
        ProdottoDAO pdao = new ProdottoDAO();
        List<Categoria> categorie=cdao.doRetrieveAll();
        List<Prodotto> prodotti=pdao.doRetrieveAll();
        req.setAttribute("categorie", categorie);
        req.setAttribute("prodotti", prodotti);
        req.getRequestDispatcher("/index.jsp").forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}
