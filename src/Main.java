import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StockManager manager = new StockManager();
        FileManager fileManager = new FileManager();
        Scanner scanner = new Scanner(System.in);
        String dbFile = "catalog.txt";

        fileManager.loadFromFile(dbFile, manager.items);

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
                        System.out.println("Product added.");
                    } catch (NumberFormatException e) {
                        System.out.println("Error: enter digits to fields of quantity and price!");
                    }
                    break;

                case "2":
                    manager.displayItems();
                    break;

                case "3":
                    System.out.print("Name of product for updating: ");
                    String updateName = scanner.nextLine();
                    try {
                        System.out.print("New quantity: ");
                        int newQuantity = Integer.parseInt(scanner.nextLine());

                        System.out.print("New price: ");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        manager.updateItem(updateName, newQuantity, newPrice);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: enter digits" + e.getMessage());
                    }
                    break;

                case "4":
                    System.out.print("Name of product for deleting: ");
                    manager.deleteItem(scanner.nextLine());
                    break;

                case "5":
                    fileManager.saveToFile(dbFile, manager.items);
                    System.out.println("Data was saved!");
                    return;

                default:
                    System.out.println("Invalid enter.");
            }
        }
    }
}
