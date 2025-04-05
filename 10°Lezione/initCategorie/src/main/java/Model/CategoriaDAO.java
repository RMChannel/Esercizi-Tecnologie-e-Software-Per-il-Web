package Model;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    public List<Categoria> doRetrieveAll() {
        List<Categoria> categories = new ArrayList<Categoria>();
        try {
            Connection con=ConPool.getConnection();
            ResultSet rs=con.createStatement().executeQuery("select * from categoria");
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setDescrizione(rs.getString("descrizione"));
                categories.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    public Categoria doRetrieveByNome(String nome) {
        Categoria c = new Categoria();
        try {
            Connection con=ConPool.getConnection();
            ResultSet rs=con.createStatement().executeQuery("select * from categoria where nome = '" + nome + "'");
            if(rs.next()) {
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setDescrizione(rs.getString("descrizione"));
            }
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}