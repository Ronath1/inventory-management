import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;

    public void connect() {
        try {
            // SQLite DB file will be created in project root
            String url = "jdbc:sqlite:inventory.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to database.");
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from database.");
            }
        } catch (SQLException e) {
            System.out.println("Error disconnecting: " + e.getMessage());
        }
    }
}