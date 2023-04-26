import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.EventHandler;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

    public class controlFormulaire extends Main{

    @FXML
    private Button ajouter;

    @FXML
    private Button annuler;

    @FXML 
    private ComboBox choix_promo;
    
    @FXML 
    private ComboBox choix_formation;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField naissance;

    

    @FXML
    public void initialize() {
       choix_promo.getItems().addAll("M1", "M2");
       choix_formation.getItems().addAll("GPHY","GCELL","ECMPS");
   }
   
    @FXML
    void valide(MouseEvent event) {
        // boolean formulaireValide = true;
        // if (nom.isEmpty()){
         // formulaireValide = false;
         // System.err.println("Le nom est obligatoire");
        // }
        // if (prenom.isEmpty()){
            // // formulaireValide = false;
            // // System.err.println("Le prenom est obligatoire");
         // }
        // if (naissance.isEmpty()){
            // formulaireValide = false;
            // System.err.println("l'année de naissance est obligatoire");
            // if (!formulaireValide) {
                // return;
            // }
        // }
                // Ajouter l'étudiant à la base de données SQLite
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:bdd_projet_ihm.db")) 
            {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO table_etu (nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (?, ?, ?, ?, ?)");
                
                stmt.setString(1, nom.getText());
                stmt.setString(2, prenom.getText());
                stmt.setString(3, naissance.getText());

                stmt.executeUpdate();
                // Afficher un message de confirmation
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("L'étudiant a été ajouté à la base de données.");
                alert.showAndWait();
                // Réinitialiser le formulaire
                initialize();
            } catch (SQLException e) {
                // En cas d'erreur, afficher un message d'erreur
                System.err.println("Une erreur est survenue: " + e.getMessage());
            }
        }
    
    
    /**
     * When this method is called, it will change the Scene 
     * to the page d'accueil scene
     */
    @FXML
    public void switchToAide(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageAide(event);
    }
    
    /**
     * When this method is called, it will change the Scene 
     * to the page d'accueil scene
     */
    @FXML
    public void switchToAccueil(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageAccueil(event);
    }
    
    /**
     * When this method is called, it will change the Scene 
     * to the page d'accueil scene
     */
    @FXML
    public void switchToListe(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageListeEtu(event);
    }
    
}
