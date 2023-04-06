import javafx.beans.property.*;

public class Etudiant {

    private IntegerProperty id;
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty formation;
    private IntegerProperty promotion;
    private IntegerProperty naissance;

    public Etudiant(int id, String nom, String prenom, String formation, int promotion, int naissance) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.formation = new SimpleStringProperty(formation);
        this.promotion = new SimpleIntegerProperty(promotion);
        this.naissance = new SimpleIntegerProperty(naissance);
    }

    // Getters and setters for the properties

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getFormation() {
        return formation.get();
    }

    public StringProperty formationProperty() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation.set(formation);
    }

    public int getPromotion() {
        return promotion.get();
    }

    public IntegerProperty promotionProperty() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion.set(promotion);
    }

    public int getNaissance() {
        return naissance.get();
    }

    public IntegerProperty naissanceProperty() {
        return naissance;
    }

    public void setNaissance(int naissance) {
        this.naissance.set(naissance);
    }
}