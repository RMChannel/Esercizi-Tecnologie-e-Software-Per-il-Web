package Model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utente {
    private int id;
    private String username;
    private String email;
    private String passwordhash;
    private boolean admin;
    public Utente(int id, String username, String email, String passwordhash, boolean admin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordhash = passwordhash;
        this.admin = admin;
    }
    public Utente() {
        this.id = 0;
        this.username = "";
        this.email = "";
        this.passwordhash = "";
        this.admin = false;
    }

    public String getPasswordhash() {
        return passwordhash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes(StandardCharsets.UTF_8));
            this.passwordhash = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
