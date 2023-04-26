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

public class page_accueil {

    @FXML
    private Button boutton_accueil;

    @FXML
    private Button boutton_aide;

    @FXML
    private Button boutton_formulaire_inscription;

    @FXML
    private Button boutton_liste_etu;
    
    /**
     * When this method is called, it will change the Scene 
     * to the page d'accueil scene
     */
    @FXML
    public void switchToFormulaire(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageFormulaire(event);
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
    public void switchToListe(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageListeEtu(event);
    }
    
    
    
}