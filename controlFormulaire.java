import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.*;

public class controlFormulaire {

    @FXML
    private Button Ajouter;

    @FXML
    private Button Annuler;

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
    private TextField naissance;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

        @FXML
    public void initialize() {
        // Initialisation des champs du formulaire
        nom.setText("");
        prenom.setText("");
        naissance.setText("");
        
    }
    
    @FXML
    //méthode appelée lors de la validation du formulaire
    void ajouter(MouseEvent event) {
        String nomText = nom.getText();
        String prenomText = prenom.getText();
        String naissanceText = naissance.getText();
        int naissance = Integer.parseInt(naissanceText);
        
        // Vérification de la validité des données du formulaire
        boolean formulaireValide = true;
        if (nomText.isEmpty()){
            formulaireValide = false;
            afficherErreur ("le nom est obligatoire");
        }
        if (prenomText.isEmpty()){
            formulaireValide = false;
            afficherErreur ("le prenom est obligatoire");
        }
        // if (naissance.isEmpty()){
            // formulaireValide = false;
            // afficherErreur ("l'année de naissance est obligatoire");
        // }
        
        //si le formulaire est valide, procéder à l'inscription
        if (formulaireValide){
            // code à executer pour procéder à l'inscription
        }
    }
    
    //Affiche un message d'erreur dans une boite de dialogue
    private void afficherErreur(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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