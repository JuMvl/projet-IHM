
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
                //Ajouter l'étudiant à la base de données SQLite
            try 
            {
                Class.forName("org.sqlite.JDBC");
                Connection conn = DriverManager.getConnection("jdbc:sqlite:bdd_projet_ihm.db");
                Statement stmt = conn.createStatement();
                String sqladd="INSERT INTO table_etu (nom_etu, prenom_etu, annee_naissance, formation, promotion) VALUES ("+nom.getText()+","+prenom.getText()+","+naissance.getText()+","+","+choix_promo.getSelectionModel().getSelectedItem().toString()+");";
                stmt.executeUpdate(sqladd);
            
                
            } catch (Exception e) {
                // En cas d'erreur, afficher un message d'erreur
                System.err.println("Une erreur est survenue: " + e.getMessage());
            }
        }
    
        
        
        
        
        
        
        
   
    @FXML
    void CliqueSurEnregistrer(MouseEvent event) {
        JOptionPane.showMessageDialog(null,"Enregistrement réussi");
    }

    @FXML
    void CliqueSurParcoursECMPS(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "ECMPS");
    }
    
    @FXML
    void CliqueSurParcoursGCell(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "GCell");
    }
    
    @FXML
    void CliqueSurParcoursGPHY(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "GPHY");
    }
    
    @FXML
    void CliqueSurPromotionM1(ActionEvent event) {
        JOptionPane.showMessageDialog(null,"M1");
    }
    
    @FXML
    void CliqueSurPromotionM2(ActionEvent event) {
        JOptionPane.showMessageDialog(null,"M2");
    }
    
    @FXML
        private void EnregistrerEtu(ActionEvent event) {
        String nomText = nom.getText().toUpperCase();//récupérer le nom rentré
        String prenomText = prenom.getText().toUpperCase();//récupérer le prenom rentré
        String naissanceText = naissance.getText();
        ArrayList <Etudiant> etudiants = new ArrayList();

        
            String promotion = choix_promo.getSelectionModel().getSelectedItem().toString();//récupérer la promotion choisi dans la liste déroulante
            String parcours = choix_formation.getSelectionModel().getSelectedItem().toString();//récupérer le parcours choisi dans la liste déroulante
            int naissance = Integer.parseInt(naissanceText);
            Etudiant etudiant = new Etudiant (0,prenomText,nomText,naissanceText,parcours,promotion);
            System.out.println("Etudiant ajouté : "+prenomText+","+nomText+","+naissance+","+parcours+","+promotion+"");//Affiche la confirmation de l'ajout avec les valeurs récupérées                         
            etudiants.add(etudiant);
             
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
