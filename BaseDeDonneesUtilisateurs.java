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
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@[host]:[port]:[schema]");
            String sql = "CREATE TABLE IF NOT EXISTS utilisateurs (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, prenom TEXT, naissance INTEGER)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
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