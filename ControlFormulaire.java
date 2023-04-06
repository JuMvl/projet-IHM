import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

    public class ControlFormulaire extends Main{

    @FXML
    private Button ajouter;

    @FXML
    private Button annuler;

    @FXML
    private RadioButton buttonECMPS;

    @FXML
    private RadioButton buttonGCELL;

    @FXML
    private RadioButton buttonGPHY;

    @FXML
    private RadioButton buttonM1;

    @FXML
    private RadioButton buttonM2;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField naissance;

    @FXML
    public void initialize() {
        // Initialisation des champs du formulaire
        nom.setText("");
        prenom.setText("");
        naissance.setText("");
    }

    @FXML
    void valide(MouseEvent event) {
        String nomText = nom.getText();
        String prenomText = prenom.getText();
        String naissanceText = naissance.getText();
        int naissance = 0;
        if (!naissanceText.isEmpty()) {
            naissance = Integer.parseInt(naissanceText);
        }
        String formation = "";
        if (buttonECMPS.isSelected()) {
            formation = "ECMPS";
        } else if (buttonGCELL.isSelected()) {
            formation = "GCELL";
        } else if (buttonGPHY.isSelected()) {
            formation = "GPHY";
        } 
        String promotion = "";
        if (buttonM1.isSelected()) {
            promotion = "M1";
        } else if (buttonM2.isSelected()) {
            promotion = "M2";
        }
        boolean formulaireValide = true;
        if (nomText.isEmpty()){
            formulaireValide = false;
            System.err.println("Le nom est obligatoire");
        }
        if (prenomText.isEmpty()){
            formulaireValide = false;
            System.err.println("Le prenom est obligatoire");
        }
        if (naissanceText.isEmpty()){
            formulaireValide = false;
            System.err.println("l'année de naissance est obligatoire");
            if (!formulaireValide) {
                    return;
            }
                // Ajouter l'étudiant à la base de données SQLite
            try (Connection conn = DriverManager.getConnection("jdbc:sqlite:gestion des étudiants.db")) {
                    PreparedStatement stmt = conn.prepareStatement("INSERT INTO etudiants (nom, prenom, naissance, formation, promotion) VALUES (?, ?, ?, ?, ?)");
                stmt.setString(1, nomText);
                stmt.setString(2, prenomText);
                stmt.setInt(3, naissance);
                stmt.setString(4, formation);
                stmt.setString(4, promotion);
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
    }
}
