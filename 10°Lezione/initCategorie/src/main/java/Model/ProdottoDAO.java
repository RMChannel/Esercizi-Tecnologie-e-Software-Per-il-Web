package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {
    public List<Prodotto> doRetrieveAll() {
        List<Prodotto> prodotti = new ArrayList<Prodotto>();
        try {
            Connection conn=ConPool.getConnection();
            ResultSet rs=conn.createStatement().executeQuery("select * from prodotto");
            while (rs.next()) {
                Prodotto prodotto = new Prodotto();
                prodotto.setId(rs.getInt("id"));
                prodotto.setNome(rs.getString("nome"));
                prodotto.setDescrizione(rs.getString("descrizione"));
                prodotti.add(prodotto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prodotti;
    }

    public List<Prodotto> doRetrieveByCategory(int id) {
        List<Prodotto> prodotti=new ArrayList<Prodotto>();
        try {
            Connection conn=ConPool.getConnection();
            ResultSet rs=conn.createStatement().executeQuery("SELECT P.id, P.nome, P.descrizione FROM prodottocategoria\n" +
                    "JOIN prodotto P ON P.id=prodottocategoria.idProdotto\n" +
                    "WHERE idCategoria="+id);
            while (rs.next()) {
                Prodotto prodotto = new Prodotto();
                prodotto.setId(rs.getInt("id"));
                prodotto.setNome(rs.getString("nome"));
                prodotto.setDescrizione(rs.getString("descrizione"));
                prodotti.add(prodotto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return prodotti;
    }
}
