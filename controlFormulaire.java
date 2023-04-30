import javafx.event.EventHandler;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.*;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.sql.*;
import javafx.scene.control.*;



    public class controlFormulaire extends Main{

    @FXML
    private Button ajouter;

    @FXML 
    private ComboBox<String> choix_promo;
    
    @FXML 
    private ComboBox<String> choix_formation;

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
    
    
    
    

    @FXML
    public void SubStudent() throws SQLException {
       
       String choix_forma = choix_formation.getSelectionModel().getSelectedItem();//récupère la formation choisi dans la combobox
       
       String choix_prom = choix_promo.getSelectionModel().getSelectedItem();
       
       PreparedStatement preparedStatement = null;
       ResultSet res = null;
              
        
     Connection conn = DriverManager.getConnection("jdbc:sqlite:bdd_projet_ihm.db");

        try { 
           preparedStatement=conn.prepareStatement("INSERT INTO table_etu (nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (?, ? , ? , ? , ? );");
           preparedStatement.setString(1, nom.getText());
           preparedStatement.setString(2, prenom.getText());
           preparedStatement.setString(3, naissance.getText());
           preparedStatement.setString(4, choix_forma);
           preparedStatement.setString(5, choix_prom);

           System.out.println(preparedStatement);
                
           preparedStatement.executeUpdate();
       } 
           catch (SQLException e) {
            System.out.println(e);
       }
    }
}
