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

@WebServlet("/getCategory")
public class CategoriaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoriaDAO dao = new CategoriaDAO();
        Categoria categoria=dao.doRetrieveByNome(request.getParameter("categoria"));
        request.setAttribute("categoria", categoria);
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        List<Prodotto> prodotti=prodottoDAO.doRetrieveByCategory(categoria.getId());
        request.setAttribute("prodotti", prodotti);
        request.getRequestDispatcher("/categoria.jsp").forward(request, response);
    }
}
