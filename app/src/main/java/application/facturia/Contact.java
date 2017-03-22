package application.facturia;

/**
 * Created by USER on 3/21/2017.
 */

public class Contact {
    String nom,email,pass;

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Contact(String nom, String email, String pass) {
        this.nom = nom;
        this.email = email;
        this.pass = pass;
    }
}
