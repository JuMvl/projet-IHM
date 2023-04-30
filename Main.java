import java.io.IOException;
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.*;

/**
 * Décrivez votre classe Main ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Main extends Application {
    private Stage primaryStage; 
    
    public static void main(String[] args) {
         Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("page_accueil.fxml");
        
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
    
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
        
    }