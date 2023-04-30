import javafx.beans.property.*;
import java.util.List;
import java.util.ArrayList;

/**
* Class etudiant qui permet de créer un etudiant
* groupe:
* version : 30/04/23
*/
public class Etudiant {

    private int id;// identifant unique d'un étudiant inscrit
    private String nom;//nom étudiant
    private String prenom;//prenom étudiant
    private String formation;// formation de l'étudiant GPHY, GCELL ou ECMPS
    private String promotion; // promotion de l'étudaint M1 ou M2
    private String naissance;//année de naissance de l'étudiant sous le format xxxx

    /**
    *Constructeur étudiant
    */
    public Etudiant(int id, String nom, String prenom, String formation, String promotion, String naissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.formation = formation;
        this.promotion = promotion;
        this.naissance = naissance;
    }

    /**
    * Getters and setters des différentes propriétés du constructeur étudiant
    */

    public int getId() {
        return id; //retourne l'id de l'étudiant
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
