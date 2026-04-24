import java.util.ArrayList;

public class AuthSystem {
    private ArrayList<User> users = new ArrayList<>();

    public AuthSystem() {
        users.add(new User("admin", "admin123", "Admin"));
        users.add(new User("user", "user123", "User"));
    }
    public User authenticate(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
