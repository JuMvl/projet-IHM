import javafx.beans.property.*;
import java.util.List;
import java.util.ArrayList;

/**
** Class etudiant qui permet de définir les differents etudiants inscrit dans la base de donnée de l'université.
*/
public class Etudiant {

    private int id;
    private String nom; //nom de l'étudiant
    private String prenom; //prenom de l'étudiant
    private String formation; //GPHY, ECMPS, GCELL
    private String promotion; //M1 ou M2
    private String naissance; //année de naissance de l'étudiant sous le format suivant: xxxx

/**
* Constructeur de la classe Etudiant
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
    *Getters and setters pour les différentes variable d'instance de la classe Etdiante
    */
    
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
