import javafx.event.ActionEvent;
import javax.swing.JRadioButton;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.sql.*;
import javafx.util.converter.IntegerStringConverter;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javax.swing.JRadioButton;
import java.util.*;
import javafx.collections.ObservableList;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
//import java.awt.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


    


public class page_liste_etu extends Main {
    
    
    @FXML
    private Button boutton_accueil;

    @FXML
    private Button boutton_aide;

    @FXML
    private RadioButton boutton_ecmps;

    @FXML
    private Button boutton_formulaire_inscription;

    @FXML
    private RadioButton boutton_gcell;

    @FXML
    private RadioButton boutton_gphy;

    @FXML
    private Button boutton_liste_etu;

    @FXML
    private Button boutton_rafraichir;

    @FXML
    private RadioButton boutton_tous;

    @FXML
    private CheckBox choix_M1;

    @FXML
    private CheckBox choix_M2;

    @FXML
    private ComboBox<String> choix_formation;

    @FXML
    private ComboBox<String> choix_promo;

    @FXML
    private TableColumn<Etudiant, String> colonne_formation;

    @FXML
    private TableColumn<Etudiant, String> colonne_id;

    @FXML
    private TableColumn<Etudiant, String> colonne_naissance;

    @FXML
    private TableColumn<Etudiant, String> colonne_nom;

    @FXML
    private TableColumn<Etudiant, String> colonne_prenom;

    @FXML
    private TableColumn<Etudiant, String> colonne_promotion;  

    @FXML
    private TextField naissance_modif;


    @FXML
    private TextField nom_modif;


    @FXML
    private TextField prenom_modif;

    @FXML
    private TableView<Etudiant> table_list_etu;
    



    private Etudiant etuModif;

    
        public void display(){
            String query = "SELECT * FROM table_etu order by id_etu ASC;";
            ArrayList <Etudiant> etudiants = new ArrayList(); //Creation d'une liste vide pour stocker les etudiants   
                try {
                    Class.forName("org.sqlite.JDBC");
                    Connection connection = DriverManager.getConnection("jdbc:sqlite:bdd_projet_ihm.db");
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) 
                        {
                            String annee_naissanceString = Integer.toString(rs.getInt("annee_naissance"));//Convertir les int en string
                            Etudiant etudiant = new Etudiant(rs.getInt("id_etu"),rs.getString("nom_etu"),rs.getString("prenom_etu"),annee_naissanceString,rs.getString("formation"),rs.getString("promotion"));
                            etudiants.add(etudiant);
                    }
                    ObservableList<Etudiant> etuOL = FXCollections.observableArrayList(etudiants);
                    
                    //Remplir le tableau avec les éléments sélectionnés dans la bdd
                    colonne_id.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdString()));
                    colonne_nom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
                    colonne_prenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
                    colonne_naissance.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNaissance()));
                    colonne_formation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFormation()));
                    colonne_promotion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPromotion()));
                    
                      
                    table_list_etu.setItems(etuOL);
                    } 
                    catch (Exception e) {
                System.err.println("Erreur lors de la récupération des étudiants: " + e.getMessage());
            }
        }
    
    
            
    
        public void displayEtudiantsoptionM1(ActionEvent event){
            if (choix_M1.isSelected()) {
                String query = "SELECT * FROM table_etu where promotion='M1'";
                try (Connection connection = DriverManager.getConnection("jdbc:sqlite:bdd_projet_ihm.db");
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query)) //variable qui stock les étudiants obtenus avec cette requette
                    {
                    ArrayList <Etudiant> etudiants = new ArrayList(); //Creation d'une liste vide pour stocker les etudiants   
                        while (rs.next()) 
                        {
                            String annee_naissanceString = Integer.toString(rs.getInt("annee_naissance"));//Convertir les int en string
                            Etudiant etudiant = new Etudiant(rs.getInt("id_etu"),rs.getString("nom_etu"),rs.getString("prenom_etu"),annee_naissanceString,rs.getString("formation"),rs.getString("promotion"));
                            System.out.println(etudiant.getPrenom());
                            etudiants.add(etudiant);
                        }
                    ObservableList<Etudiant> etuOL = FXCollections.observableArrayList(etudiants);
                    
                    //Remplir le tableau avec les éléments sélectionnés dans la bdd
                    colonne_nom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
                    colonne_prenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
                    colonne_promotion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPromotion()));
                    colonne_formation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFormation()));
                    colonne_naissance.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNaissance()));
                      
                    table_list_etu.setItems(etuOL);
                    } 
                    catch (SQLException e) {
                System.err.println("Erreur lors de la récupération des étudiants: " + e.getMessage());
            }
            }
        }
        
        public void displayEtudiantsoptionM2(ActionEvent event){
            if (choix_M2.isSelected()) {
                String query = "SELECT * FROM table_etu where promotion='M2'";
                try (Connection connection = DriverManager.getConnection("jdbc:sqlite:bdd_projet_ihm.db");
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query)) //variable qui stock les étudiants obtenus avec cette requette
                    {
                    ArrayList <Etudiant> etudiants = new ArrayList(); //Creation d'une liste vide pour stocker les etudiants   
                        while (rs.next()) 
                        {
                            String annee_naissanceString = Integer.toString(rs.getInt("annee_naissance"));//Convertir les int en string
                            Etudiant etudiant = new Etudiant(rs.getInt("id_etu"),rs.getString("nom_etu"),rs.getString("prenom_etu"),annee_naissanceString,rs.getString("formation"),rs.getString("promotion"));
                            System.out.println(etudiant.getPrenom());
                            etudiants.add(etudiant);
                        }
                    ObservableList<Etudiant> etuOL = FXCollections.observableArrayList(etudiants);
                    
                    //Remplir le tableau avec les éléments sélectionnés dans la bdd
                    colonne_nom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
                    colonne_prenom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));
                    colonne_promotion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPromotion()));
                    colonne_formation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFormation()));
                    colonne_naissance.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNaissance()));
                    
                    table_list_etu.setItems(etuOL);
                    } 
                    catch (SQLException e) {
                System.err.println("Erreur lors de la récupération des étudiants: " + e.getMessage());
            }
            }
        }
    
       @FXML
    public void initialize() {
       choix_promo.getItems().addAll("M1", "M2");
       choix_formation.getItems().addAll("GPHY","GCELL","ECMPS");
       }  
   
     @FXML
    public void choisirEtuModif(MouseEvent e) throws IOException{
        etuModif = table_list_etu.getSelectionModel().getSelectedItem();
        
        nom_modif.setText(etuModif.getNom());
        prenom_modif.setText(etuModif.getPrenom());
        naissance_modif.setText(etuModif.getNaissance());
        choix_formation.setValue(etuModif.getFormation());
        choix_promo.setValue(etuModif.getPromotion());
    }   
        
    /**
     * This method allows to handles the event of modify a student in a database, it display error if one parameter is empty
     */
    @FXML
    public void editStudent() throws SQLException {
       PreparedStatement preparedStatement = null;
       ResultSet res = null;
       String choix_forma = choix_formation.getSelectionModel().getSelectedItem();//récupère la formation choisi dans la combobox
       String choix_prom = choix_promo.getSelectionModel().getSelectedItem();
       Connection conn = DriverManager.getConnection("jdbc:sqlite:bdd_projet_ihm.db");
       try {
            preparedStatement = conn.prepareStatement("UPDATE table_etu SET nom_etu = ?, prenom_etu = ?, annee_naissance = ?, formation = ?, promotion = ? WHERE id_etu = ?;");
            preparedStatement.setString(1, nom_modif.getText());
           preparedStatement.setString(2, prenom_modif.getText());
           preparedStatement.setString(3, naissance_modif.getText());
           preparedStatement.setString(4, choix_forma);
           preparedStatement.setString(5, choix_prom);


            
            System.out.println(preparedStatement);
            
            preparedStatement.executeUpdate();
            
          
        } 
       catch (SQLException e) {
            System.out.println(e);
        }
            
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
    
    }

    

                
    
   