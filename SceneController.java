import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.event.*;

/**
 * Class scene controller where you can set the different pages shown on the screen
 *
 */
public class SceneController
{
    /**
     * Set the window shown on the add page
     * @param event : event change the page
     */
    public void setPageInscription(ActionEvent event){
        setPage(event,"formulaire d'inscription.fxml");
    }
    
    /**
     * Set the window shown on the list page
     * @param event : event change the page
     */
    public void setPageListe(ActionEvent event){
        setPage(event,"page_liste_etu.fxml");
    }
    
   
    /**
     * Set the window shown on the home page
     * @param event : event change the page
     */
    public void setPageAccueil(ActionEvent event){
        setPage(event,"page_accueil.fxml");
    }
    
    /**
     * Configure the window on the screen to be a new one 
     * @param event : event change the page
     * @param pageFXML : the new page which will be shown on the screen
     */
    private void setPage(ActionEvent event,String pageFXML){
      try
      {
          Stage primaryStage = new Stage();
          Parent root = FXMLLoader.load(getClass().getResource(pageFXML));
          Scene scene = new Scene(root);
          primaryStage.setTitle("Application");
          primaryStage.setScene(scene);
          primaryStage.show();
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          stage.close();
      }
      catch (java.io.IOException ioe)
      {
          ioe.printStackTrace();
      }
    }
}
