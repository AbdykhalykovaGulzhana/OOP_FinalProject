import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class FileManager {
    public void saveToFile(String fileName, ArrayList<Product> items) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for (Product product : items) {
                writer.println(product.getName() + "," + product.getQuantity() + "," + product.getPrice() + "," + product.getCategory());
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Error of saving file:" + e.getMessage());
        }
    }

    public void loadFromFile(String fileName, ArrayList<Product> items) {
        items.clear();

        try {
            Scanner scanner = new Scanner (new File(fileName));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                if (data.length >= 4) {
                   String name = data[0];
                   int quantity = Integer.parseInt(data[1]);
                   double price = Double.parseDouble(data[2]);
                   String category = data[3];

                   items.add(new Product(name, quantity, price, category));
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error of loading file: " + e.getMessage());
        }
    }
}
