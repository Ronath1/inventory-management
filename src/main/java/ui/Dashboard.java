package ui;

import dao.ProductDAO;
import model.Product;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Dashboard {
    private ProductDAO productDAO;
    private Scanner scanner;

    public Dashboard(Connection connection) {
        productDAO = new ProductDAO(connection);
        scanner = new Scanner(System.in);
    }

    public void show() {
        while (true) {
            System.out.println("\n--- Inventory Management Dashboard ---");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Search Products");
            System.out.println("6. Sort Products");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: addProduct(); break;
                case 2: viewProducts(); break;
                case 3: updateProduct(); break;
                case 4: deleteProduct(); break;
                case 5: searchProducts(); break;
                case 6: sortProducts(); break;
                case 0: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void addProduct() {
        System.out.print("Product name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        Product product = new Product(0, name, quantity, price);
        productDAO.addProduct(product);
        System.out.println("Product added.");
    }

    private void viewProducts() {
        List<Product> products = productDAO.getAllProducts();
        System.out.println("\n--- Product List ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("New name: ");
        String name = scanner.nextLine();
        System.out.print("New quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("New price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Product product = new Product(id, name, quantity, price);
        productDAO.updateProduct(product);
        System.out.println("Product updated.");
    }

    private void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        productDAO.deleteProduct(id);
        System.out.println("Product deleted.");
    }

    private void searchProducts() {
        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine();
        List<Product> products = productDAO.searchProducts(keyword);
        System.out.println("\n--- Search Results ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    private void sortProducts() {
        System.out.print("Sort by (name/quantity/price): ");
        String column = scanner.nextLine();
        System.out.print("Ascending? (true/false): ");
        boolean ascending = scanner.nextBoolean();
        scanner.nextLine();
        List<Product> products = productDAO.sortProductsBy(column, ascending);
        System.out.println("\n--- Sorted Products ---");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}