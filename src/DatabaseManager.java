import java.sql.*;

class DatabaseManager {

    private static final String URL = "jdbc:sqlite:catalog.db";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS products (" +
                "name TEXT PRIMARY KEY, " +
                "quantity INTEGER, " +
                "price REAL, " +
                "category TEXT" +
                ")";

        try (Connection connection = connect();
             Statement stmt = connection.createStatement()) {

            stmt.execute(sql);

        } catch (Exception e) {
            System.out.println("Error creating table" + e.getMessage());
        }
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO products VALUES(?, ?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getCategory());

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error of adding product" + e.getMessage());
        }
    }

    public void deleteProduct(String name) {
        String sql = "DELETE FROM products WHERE name = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
            System.out.println("Product was deleted.");
        } catch (Exception e) {
            System.out.println("Error of deleting: " + e.getMessage());
        }
    }

    public void updateProduct(String name, int quantity, double price) {
        String sql = "UPDATE products SET quantity = ?, price = ? WHERE name = ?";
        try (Connection connection = connect();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, quantity);
            stmt.setDouble(2, price);
            stmt.setString(3, name);
            stmt.executeUpdate();
            System.out.println("Database was updated.");
        } catch (Exception e) {
            System.out.println("Error of updating: " + e.getMessage());
        }
    }

    public void showProducts() {
        String sql = "SELECT * FROM products";

        try (Connection connection = connect();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {

                System.out.println(
                        rs.getString("name") + " | " +
                                rs.getInt("quantity") + " | " +
                                rs.getDouble("price") + " | " +
                                rs.getString("category")
                );
            }
        } catch (Exception e) {
            System.out.println("Error of reading data");
        }
    }
}
