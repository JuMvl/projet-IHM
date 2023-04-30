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
    public void setPageFormulaire(ActionEvent event){
        setPage(event,"formulaire d'inscription.fxml");
    }
    
    /**
     * Set the window shown on the list page
     * @param event : event change the page
     */
    public void setPageListeEtu(ActionEvent event){
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
     * Set the window shown on the home page
     * @param event : event change the page
     */
    public void setPageAide(ActionEvent event){
        setPage(event,"page_aide.fxml");
    }
    
    /**
     * Set the window shown on the home page
     * @param event : event change the page
     */
    public void setPageModifEtu(ActionEvent event){
        setPage(event,"page_modif_etu.fxml");
    }
    
    /**
     * Configure the window on the screen to be a new one 
     * @param event : event change the page
     * @param pageFXML : the new page which will be shown on the screen
     */
    private void setPage(ActionEvent event,String pageFXML){
      try
      {
          Parent Parent = FXMLLoader.load(getClass().getResource(pageFXML));
          Scene Scene = new Scene (Parent);
          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
          window.setScene(Scene);
          window.show();
      }
      catch (java.io.IOException ioe)
      {
          ioe.printStackTrace();
      }
    }
}


