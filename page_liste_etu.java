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
    
    public class page_liste_etu extends Main {
    
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
        private TableColumn<Etudiant, String> colonne_formation;
    
        @FXML
        private TableColumn<Etudiant, String> colonne_nom;
    
        @FXML
        private TableColumn<Etudiant, String> colonne_prenom;
    
        @FXML
        private TableColumn<Etudiant, Integer> colonne_promotion;
        
        @FXML
        private TableColumn<Etudiant, Integer> colonne_naissance;
    
        @FXML
        private TextField search_bar;
    
        @FXML
        private TableView<Etudiant> table_list_etu;
    
        /**
         * When this method is called, it will change the Scene to the page d'accueil
         * scene
         */
        public void switchToPageAccueil(MouseEvent event) {
            try {
                Parent page_accueilParent = FXMLLoader.load(getClass().getResource("page_accueil.fxml"));
                Scene page_accueilScene = new Scene(page_accueilParent);// JavaFX must have a Scene (window content) inside a
                                                                       // Stage (window)
                // Getting the stage information
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
                window.setScene(page_accueilScene);
                window.show();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    
        /**
         * Retrieves and displays the list of students from the database
         */
        public void displayEtudiants() {
            String query = "SELECT * FROM etudiants";
            try (Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    int naissance = rs.getInt("date_de_naissance");
                    String formation = rs.getString("formation");
                    int promotion = rs.getInt("promotion");
                    Etudiant etudiant = new Etudiant(id, nom, prenom, formation, promotion, naissance);
                    table_list_etu.getItems().add(etudiant);
                }
            } catch (SQLException e) {
                System.err.println("Erreur lors de la récupération des étudiants: " + e.getMessage());
            }
        }
    
        /**
         * Initializes the table columns and displays the list of students
         */
        @FXML
        private void initialize() {
            colonne_nom.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
            colonne_prenom.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
            colonne_promotion.setCellValueFactory(cellData -> cellData.getValue().promotionProperty().asObject());
            colonne_formation.setCellValueFactory(cellData -> cellData.getValue().formationProperty());
            //colonne_naissance.setCellValueFactory(cellData -> cellData.getValue().naissanceProperty());
            
            // Enable editing of the "nom" column
            colonne_nom.setCellFactory(TextFieldTableCell.forTableColumn());
            colonne_nom.setOnEditCommit((CellEditEvent<Etudiant, String> event) -> {
                Etudiant etudiant = event.getRowValue();
                etudiant.setNom(event.getNewValue());
                // Update the database with the new name
                updateEtudiant(etudiant);
            });
            
            // Enable editing of the "prenom" column
            colonne_prenom.setCellFactory(TextFieldTableCell.forTableColumn());
            colonne_prenom.setOnEditCommit((CellEditEvent<Etudiant, String> event) -> {
                Etudiant etudiant = event.getRowValue();
                etudiant.setPrenom(event.getNewValue());
                // Update the database with the new prenom
                updateEtudiant(etudiant);
            });
            
            // Enable editing of the "promotion" column
            colonne_promotion.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            colonne_promotion.setOnEditCommit((CellEditEvent<Etudiant, Integer> event) -> {
                Etudiant etudiant = event.getRowValue();
                etudiant.setPromotion(event.getNewValue());
                // Update the database with the new promotion
                updateEtudiant(etudiant);
            });
            
            // Enable editing of the "naissance" column
            colonne_naissance.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            colonne_naissance.setOnEditCommit((CellEditEvent<Etudiant, Integer> event) -> {
                Etudiant etudiant = event.getRowValue();
                etudiant.setNaissance(event.getNewValue());
                // Update the database with the new naissance
                updateEtudiant(etudiant);
            });
    
            displayEtudiants();
        }
        
        /**
         * Updates the information of an existing student in the database
         */
        private void updateEtudiant(Etudiant etudiant) {
            String query = "UPDATE etudiants SET nom=?, prenom=?, promotion=? WHERE id=?";
            try (Connection connection = DriverManager.getConnection("jdbc:sqlite:gestion des étudiants.db");
                    PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, etudiant.getNom());
                pstmt.setString(2, etudiant.getPrenom());
                pstmt.setInt(3, etudiant.getPromotion());
                pstmt.setInt(4, etudiant.getId());
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la mise à jour de l'étudiant: " + e.getMessage());
            }
        }
    }