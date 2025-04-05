package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO {
    public Utente doRetrieveByUsernamePassword(String username, String password) {
        try {
            Connection con = ConPool.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT id, username, passwordhash, email, admin FROM utente WHERE username=? AND passwordhash=SHA1(?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente utente = new Utente();
                utente.setId(rs.getInt("id"));
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("passwordhash"));
                utente.setEmail(rs.getString("email"));
                utente.setAdmin(rs.getBoolean("admin"));
                return utente;
            }
            else return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doUserExists(String username) {
        try {
            Connection con = ConPool.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * from utente WHERE username=?");
            ps.setString(1, username);
            ResultSet rs=ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doEmailExists(String email) {
        try {
            Connection con = ConPool.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT * from utente WHERE email=?");
            ps.setString(1, email);
            ResultSet rs=ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSave(Utente utente) {
        try {
            Connection con=ConPool.getConnection();
            PreparedStatement ps=con.prepareStatement("INSERT INTO utente (username, passwordhash, email, admin) VALUES (?,?,?,?)");
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getPasswordhash());
            ps.setString(3, utente.getEmail());
            ps.setBoolean(4, utente.isAdmin());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
