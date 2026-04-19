import java.util.ArrayList;

class StockManager {
    ArrayList<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public void displayItems() {
        for (Product product : items) {
            product.display();
        }
    }

    public Product searchItem(String name) {
        for (Product product : items) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void deleteItem(String name) {
        boolean removed = items.removeIf(product -> product.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Product deleted");
        } else {
            System.out.println("Product not found");
        }
    }

    public void updateItem(String name, int quantity, double price) {
        Product product = searchItem(name);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product not found.");
        }
    }
}

