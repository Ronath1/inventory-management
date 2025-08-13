import ui.Dashboard;

public class App {
    public static void main(String[] args) {
        // Initialize the application
        System.out.println("Starting Inventory Management System...");

        // Set up the database connection
        DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.connect();

        // Launch the dashboard
        Dashboard dashboard = new Dashboard(dbConnection.getConnection());
        dashboard.show();

        dbConnection.disconnect();
    }
}