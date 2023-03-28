
/**
 * Décrivez votre classe Utilisateur ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */

public class Utilisateur {
    private String nom;
    private String prenom;
    private int naissance;
    
    public Utilisateur(String nom, String prenom, int naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public int getNaissance() {
        return naissance;
    }
    
    public void setNaissance(int naissance) {
        this.naissance = naissance;
    }
}