
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

public class page_accueil {

    @FXML
    private Button boutton_accueil;

    @FXML
    private Button boutton_aide;

    @FXML
    private Button boutton_formulaire_inscription;

    @FXML
    private Button boutton_liste_etu;

    @FXML
    void page_accueil(MouseEvent event) {

    }

    @FXML
    void page_aide(MouseEvent event) {

    }

    @FXML
    void page_formulaire(MouseEvent event) {

    }

    @FXML
    void page_liste_etu(MouseEvent event) {
         
    }
 /**
     * When this method is called, it will change the Scene 
     * to the page d'accueil scene
     // */
    // public void changeScreenButtonPushed(ActionEvent event)
    // {
        // try
            // {
            // Parent page_accueilParent = FXMLLoader.load(getClass().getResource("page_liste_etu.fxml"));
            // Scene page_accueilScene = new Scene (page_accueilParent);// JavaFX must have a Scene (window content) inside a Stage (window)
            // //Getting the stage information
            // Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            // window.setScene(page_accueilScene);
            // window.show();
            // }
            // catch (IOException ioe)
            // {
            // ioe.printStackTrace();
            // }// Building the FXML hierarchy
    // }
}
