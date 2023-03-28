import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.sql.*;
import java.awt.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import javafx.fxml.Initializable;


public class page_liste_etu implements Initializable {

    @FXML
    private Button boutton_accueil;

    @FXML
    private Button boutton_aide;

    @FXML
    private Button boutton_formulaire_inscription;

    @FXML
    private Button boutton_liste_etu;

    @FXML
    private CheckBox choix_M1;

    @FXML
    private CheckBox choix_M2;

    @FXML
    private MenuButton choix_parcours;

    @FXML
    private TableColumn<?, ?> colonne_formation;

    @FXML
    private TableColumn<?, ?> colonne_nom;

    @FXML
    private TableColumn<?, ?> colonne_prenom;

    @FXML
    private TableColumn<?, ?> colonne_promotion;

    @FXML
    private TextField search_bar;

    @FXML
    private TableView<?> table_list_etu;

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
     */
    public void changeScreenButtonPushed(ActionEvent event)
    {
        try
            {
            Parent page_accueilParent = FXMLLoader.load(getClass().getResource("page_accueil.fxml"));
            Scene page_accueilScene = new Scene (page_accueilParent);// JavaFX must have a Scene (window content) inside a Stage (window)
            //Getting the stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(page_accueilScene);
            window.show();
            }
            catch (IOException ioe)
            {
            ioe.printStackTrace();
            }// Building the FXML hierarchy
    }
    
    }
