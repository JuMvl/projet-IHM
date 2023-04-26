import javafx.event.ActionEvent;
import javax.swing.JRadioButton;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.sql.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javax.swing.JRadioButton;
import javafx.scene.control.*;
import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.scene.control.CheckBox;
    import javafx.scene.control.MenuButton;
    import javafx.scene.control.TableColumn;
    import javafx.scene.control.TableView;
    import javafx.scene.control.TextField;
    import javafx.scene.input.MouseEvent;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import javafx.scene.Node;
    import javafx.fxml.FXMLLoader;
    import java.io.IOException;
    import java.sql.*;
    import javafx.scene.control.cell.TextFieldTableCell;
    import javafx.util.converter.IntegerStringConverter;
    import javafx.scene.control.TableColumn.CellEditEvent;
    import javafx.fxml.FXML;


    public class page_liste_etu extends Main {
    
        @FXML
        private Button boutton_accueil;
    
        @FXML
        private Button boutton_aide;
        
        @FXML
        private Button boutton_rafraichir;
        
        @FXML
        private Button boutton_formulaire_inscription;
    
        @FXML
        private Button boutton_liste_etu;
    
        @FXML
        private CheckBox choix_M1;
    
        @FXML
        private CheckBox choix_M2;
    
        //@FXML
        //private MenuButton choix_parcours;
        @FXML
        private RadioButton boutton_tous_M;
        
        @FXML
        private RadioButton boutton_ecmps;
        
        @FXML
        private RadioButton boutton_gphy;
        
        @FXML
        private RadioButton boutton_gcell;
        
        @FXML
        private RadioButton boutton_tous;
    
        @FXML
        private TableColumn<Etudiant, String> colonne_formation;
    
        @FXML
        private TableColumn<Etudiant, String> colonne_nom;
    
        @FXML
        private TableColumn<Etudiant, String> colonne_prenom;
    
        @FXML
        private TableColumn<Etudiant, String> colonne_promotion;
        
        @FXML
        private TableColumn<Etudiant, String> colonne_id;
        
        @FXML
        private TableColumn<Etudiant, String> colonne_naissance;
    
        @FXML
        private TextField search_bar;
    
        @FXML
        private TableView<Etudiant> table_list_etu;
    
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
                    colonne_promotion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPromotion()));
                    colonne_formation.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFormation()));
                    colonne_naissance.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNaissance()));
                      
                    table_list_etu.setItems(etuOL);
                    } 
                    catch (Exception e) {
                System.err.println("Erreur lors de la récupération des étudiants: " + e.getMessage());
            }
        }
    
    
        /**
         * Updates the information of an existing student in the database
         */
        private void updateEtudiant(Etudiant etudiant) {
            String query = "UPDATE table_etu SET nom=?, prenom=?, promotion=? WHERE id=?";
            try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestion des étudiants.db");
                    PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, etudiant.getNom());
                pstmt.setString(2, etudiant.getPrenom());
                pstmt.setString(3, etudiant.getPromotion());
                pstmt.setInt(4, etudiant.getId());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la mise à jour de l'étudiant: " + e.getMessage());
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
}
                
    
   