import java.io.IOException;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import java.sql.Connection;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.time.LocalDateTime;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 * Décrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Main extends Application {
    private Stage primaryStage;
    private BorderPane root;
    

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("page_accueil.fxml");
        
        initRootLayout();
    }
     
    public static void main(String[] args) {
        Application.launch(args);
    }
    

    /**
     * Initializes the root layout
     */
    public void initRootLayout(){ 
        
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("page_accueil.fxml"));
            Scene scene = new Scene (root);// JavaFX must have a Scene (window content) inside a Stage (window)
            // Création de la scène (avec des dimensions correspondant à une résolution HD), composé uniquement d'une étiquette affichant du texte
            primaryStage.setScene(scene);
            primaryStage.show();
            
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }// Building the FXML hierarchy
        
    }
    // /**
     // * Shows the person overview inside the root layout.
     // */
    // public void showPersonOverview() {
        // try {
            // // Load person overview.
            // FXMLLoader loader = new FXMLLoader();
            // loader.setLocation(Main.class.getResource("view/PersonOverview.fxml"));
            // AnchorPane personOverview = (AnchorPane) loader.load();
            
            // // Set person overview into the center of root layout.
            // rootLayout.setCenter(personOverview);
        // } catch (IOException e) {
            // e.printStackTrace();
        // }
    // }
    
    // /**
     // * Returns the main stage.
     // * @return
     // */
    // public Stage getPrimaryStage() {
        // return primaryStage;
    // }

    private static Connection connect(String location){
        String dbPrefix = "jdbc:sqlite:";
        Connection connection;
        try{
            connection = DriverManager.getConnection(dbPrefix + location);
        } catch (SQLException exception){
            Logger.getAnonymousLogger().log(Level.SEVERE,
            LocalDateTime.now() + ":Could not connect to SQLite DB at " +
            location);
            return null;
        }
        return connection;
        }
    }