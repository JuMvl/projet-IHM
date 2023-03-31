import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDeDonneesUtilisateurs {
    private static BaseDeDonneesUtilisateurs instance = null;
    private Connection connection = null;
    
    // méthode pour récupérer l'instance unique de la classe
    public static BaseDeDonneesUtilisateurs getInstance() {
        if (instance == null) {
            instance = new BaseDeDonneesUtilisateurs();
        }
        return instance;
    }
    
    // constructeur privé pour empêcher l'instanciation directe de la classe
    private BaseDeDonneesUtilisateurs() {
    // initialisation de la connexion à la base de données
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/fight/OneDrive/Documents/M1 GPHY/IHM/javaFX/base de données/gestion des étudiants.SQLite");
            if ( connection != null ){
            System.out.println("Connexion etablie");
            }
        } catch ( Exception ex ) {
         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
         System.out.println("Erreur de connexion");
        }
    }
    
    // méthode pour ajouter un utilisateur à la base de données
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        try {
            String sql = "INSERT INTO utilisateurs (nom, prenom, naissance) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, utilisateur.getNom());
            statement.setString(2, utilisateur.getPrenom());
            statement.setInt(3, utilisateur.getNaissance());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}