import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StockManager manager = new StockManager();
        DatabaseManager db = new DatabaseManager();
        FileManager fileManager = new FileManager();
        AuthSystem auth = new AuthSystem();
        Scanner scanner = new Scanner(System.in);
        String dbFile = "catalog.txt";

        db.createTable();
        fileManager.loadFromFile(dbFile, manager.items);

        User currentUser = null;
        System.out.println("Welcome to Stock Management System");

        while (currentUser == null) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            currentUser = auth.authenticate(username, password);

            if (currentUser == null) {
                System.out.println("Invalid credentials! Try again.");
            }
        }
        System.out.println("Login successful! Welcome, " + currentUser.getUsername() + " (" + currentUser.getRole() + ")");

        StockGUI gui = new StockGUI(manager, db);
        gui.setVisible(true);

        while (true) {
            System.out.println("\n--- Stock Item Catalog ---");
            System.out.println("1. Create product.");
            System.out.println("2. Show all products.");
            System.out.println("3. Update product.");
            System.out.println("4. Delete product.");
            System.out.println("5. Exit.");
            System.out.print("Choose action: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (!currentUser.getRole().equals("Admin")) {
                        System.out.println("Access Denied! Only Admins can add products.");
                        break;
                    }
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Error! Field of name cannot be empty");
                        break;
                    }

                    try {
                        System.out.print("Quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        System.out.print("Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        System.out.print("Category: ");
                        String category = scanner.nextLine();

                        if (category.isEmpty()) {
                            System.out.println("Category cannot be empty");
                            break;
                        }

                        manager.addItem(new Product(name, quantity, price, category));
                        db.addProduct(new Product(name, quantity, price, category));
                        gui.updateTable();
                        System.out.println("Product added.");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: enter digits to fields of quantity and price!");
                    }
                    break;


                case "2":
                    manager.displayItems();
                    db.showProducts();
                    break;

                case "3":
                    if (!currentUser.getRole().equals("Admin")) {
                        System.out.println("Access Denied!");
                        break;
                    }
                    System.out.print("Name of product for updating: ");
                    String updateName = scanner.nextLine();
                    try {
                        System.out.print("New quantity: ");
                        int newQuantity = Integer.parseInt(scanner.nextLine());

                        System.out.print("New price: ");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        manager.updateItem(updateName, newQuantity, newPrice);
                        db.updateProduct(updateName, newQuantity, newPrice);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: enter digits" + e.getMessage());
                    }
                    break;


                case "4":
                    if (!currentUser.getRole().equals("Admin")) {
                        System.out.println("Access Denied! Only Admins can delete.");
                        break;
                    }

                    System.out.print("Name of product for deleting: ");
                    String delName = scanner.nextLine();
                    manager.deleteItem(delName);
                    db.deleteProduct(delName);
                    gui.updateTable();
                    System.out.println("Product deleted.");
                    break;

                case "5":
                    fileManager.saveToFile(dbFile, manager.items);
                    System.out.println("Data was saved!");
                    System.exit(0);
                    return;

                default:
                    System.out.println("Invalid enter.");
            }
        }
    }
}
