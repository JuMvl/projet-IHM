import java.io.IOException;
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.*;

/**
 * Main est la classe principale qui lance l'application
 *
 * @author 
 * @version 30/04/23
 */
public class Main extends Application {
    private Stage primaryStage; 
    
    
    /**
    *initialissation de l'application
    */
    public static void main(String[] args) {
         Application.launch(args);
    }
    
    /**
    *Creation et affichage de la fenetre principale page_accueil.fxml
    */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("page_accueil.fxml");//definit le titre de la fenetre principale
        
            try
        {
            Parent root = FXMLLoader.load(getClass().getResource("page_accueil.fxml"));//charge le fichier FXML page_accueil.fxml
            Scene scene = new Scene (root);//creation d'une nouvelle scène
            // Création de la scène (avec des dimensions correspondant à une résolution HD), composé uniquement d'une étiquette affichant du texte
            primaryStage.setScene(scene);
            primaryStage.show();//affichage de la fenetre
            
        }
  
        catch (IOException ioe)//si un problème survient pendant le chargement du fichier une erreur IOExceptioon apparait
        {
            ioe.printStackTrace();
        }

    }
    
    /**
     * GetPrimaryStage renvoie l'object Stage utilisé pour afficher la fenetre principale de l'application
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
        
    }
