package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

/**
 * A small table of banking customers for testing.
 */

public class CustomerDAO {


    /**
     * Finds the customer with the given ID.
     * Returns null if there is no match.
     */

    public Customer doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, firstName, lastName, balance, favorite FROM customer WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer p = new Customer();
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setBalance(rs.getDouble(4));
                p.setFavorite(rs.getBoolean(5));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    // la funzione seguente � inutile perch� il DB � riempito tramite tool esterno
    // sarebbe utile se l'applicazione fornisse un form per riempirlo. IDEA! aggiungi questa feature all'applicazione
    // � un buon modo per verificare la sua correttezza

    public void doSave(Customer customer) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO customer (firstName, lastName, balance) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setDouble(3, customer.getBalance());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            customer.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Double alwaysPositive(Double value) {
        if(value>=0) return value;
        else return value*-1;
    }

    public List<Customer> doRetrieveAll() {
        List<Customer> customers = new ArrayList<Customer>();
        try (Connection con=ConPool.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                customers.add(new Customer(rs.getString(2),rs.getString(3),rs.getInt(1),rs.getDouble(4),alwaysPositive(rs.getDouble(4)),rs.getBoolean(5)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public void editCustomer(String firstname, String lastname, Double balance, int id) {
        try (Connection con=ConPool.getConnection()) {
            PreparedStatement preparedStatement=con.prepareStatement("UPDATE customer SET firstName=?,lastName=?,balance=? WHERE id=?");
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setDouble(3, balance);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFavorite(boolean favorite, int id) {
        try(Connection con=ConPool.getConnection()) {
            PreparedStatement preparedStatement=con.prepareStatement("UPDATE customer SET favorite=? WHERE id=?");
            preparedStatement.setBoolean(1, favorite);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


