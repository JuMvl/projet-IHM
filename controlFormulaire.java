import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class controlFormulaire {

    @FXML
    private Button Ajouter;

    @FXML
    private Button Annuler;

    @FXML
    private CheckBox checkECMPS;

    @FXML
    private CheckBox checkGCELL;

    @FXML
    private CheckBox checkGPHY;

    @FXML
    private CheckBox checkM1;

    @FXML
    private CheckBox checkM2;

    @FXML
    private TextField naissance;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    void ajouter(MouseEvent event) {
    }

    @FXML
    private void fermer(MouseEvent event) {
    // Fermer le système
    System.exit(0);
    }

    @FXML
    void valide(MouseEvent event) {

    }

}