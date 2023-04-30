import javafx.beans.property.*;
import java.util.List;
import java.util.ArrayList;

public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private String formation;
    private String promotion; // 1 pour les M1 et 2 pour les M2
    private String naissance;

    public Etudiant(int id, String nom, String prenom, String formation, String promotion, String naissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.formation = formation;
        this.promotion = promotion;
        this.naissance = naissance;
    }

    // Getters and setters for the properties

    public int getId() {
        return id;
    }

 

    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom=nom;
    }

    public String getPrenom() {
        return prenom;
    }

    // public StringProperty prenomProperty() {
        // return prenom;
    // }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation=formation;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion=promotion;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }
    
    public String getIdString (){
        String idString = Integer.toString(id);
        return idString;
    }
}
