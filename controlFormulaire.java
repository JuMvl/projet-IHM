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

/**
* controlFormulaire est une classe qui permet de gérer l'ajout d'un étudiant grâce à un formulaire sur une page scène bulder
* @version 30/04/23
* @groupe
*/

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

    /**
    * Initialize permet d'ajouter les différentes formations et promotions dans deux menus déroulants (choix_promo et choix_formation)
    */

    @FXML
    public void initialize() {
       choix_promo.getItems().addAll("M1", "M2");
       choix_formation.getItems().addAll("GPHY","GCELL","ECMPS");
   }
         
    /**
     * switchToAide permet de naviger de la page actuelle vers la page aide
     */
    @FXML
    public void switchToAide(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageAide(event);
    }
    
    /**
     *switchToAccueil permet de naviger de la page actuelle vers la page accueil (page principale)
     */
    @FXML
    public void switchToAccueil(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageAccueil(event);
    }
    
    /**
     * switchToListe permet de naviger de la page actuelle vers la page lsite des étudiants
     */
    @FXML
    public void switchToListe(ActionEvent event)throws IOException {
        SceneController page = new SceneController();
        page.setPageListeEtu(event);
    }
    
    
   /**
   *SubStudent permet d'enregistrer les données d'un étudiant à la base de donnée
   */
    @FXML
    public void SubStudent() throws SQLException {
       //récupération de la promotion et formation sélectionnée dans leux combobox
       String choix_forma = choix_formation.getSelectionModel().getSelectedItem();
       String choix_prom = choix_promo.getSelectionModel().getSelectedItem();
       
        //
       PreparedStatement preparedStatement = null;
       ResultSet res = null;
              
        //Connexion à la base de donnée
     Connection conn = DriverManager.getConnection("jdbc:sqlite:bdd_projet_ihm.db");

        try { 
            //requete SQL pour insérer un etudiant dans la table table_etu
           preparedStatement=conn.prepareStatement("INSERT INTO table_etu (nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES (?, ? , ? , ? , ? );");
           //definission des valeurs à rentrer dans la table table_etu en fonction de ce que l'utilisateur a renseigné
           preparedStatement.setString(1, nom.getText());
           preparedStatement.setString(2, prenom.getText());
           preparedStatement.setString(3, naissance.getText());
           preparedStatement.setString(4, choix_forma);
           preparedStatement.setString(5, choix_prom);

           System.out.println(preparedStatement);
                
           preparedStatement.executeUpdate();//execution de la requete
       } 
        //si une erreur apparait lors de l'excécution une erreur apparait
           catch (SQLException e) {
            System.out.println(e);
       }
    }
}
