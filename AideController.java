import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.scene.Node;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

public class AideController {

    @FXML
    private Button boutton_accueil;

    @FXML
    private Button boutton_aide;

    @FXML
    private Button boutton_formulaire_inscription;

    @FXML
    private Button boutton_liste_etu;
    
    /**
     * switchToFormulaire permet de naviguer de la page actuelle vers la page formulaire pour ajouter un étudiant
     */
    @FXML
    public void switchToFormulaire(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageFormulaire(event);
    }
    
    /**
     * switchToAccueil permet de naviguer de la page actuelle vers la page accueil (principale)
     */
    @FXML
    public void switchToAccueil(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageAccueil(event);
    }
    
    /**
     * switchToListe permet de naviguer de la page actuelle vers la page Liste des etudiants pour ajouter visualiser tous les étudiants
     */
    @FXML
    public void switchToListe(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageListeEtu(event);
    }
    
    }
