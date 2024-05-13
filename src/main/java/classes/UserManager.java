package classes;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages users by storing them in a dictionary with usernames as keys and passwords as values.
 */
public class UserManager {
    private Map<String, String> users;

    /**
     * Constructs a new UserManager object.
     */
    public UserManager() {
        this.users = new HashMap<>();
    }

    // Additional methods can be added here for managing users

    /**
     * Generates the dictionary of users.
     *
     * @return The dictionary of users.
     */
    public Map<String, String> getUsers() {
        return users;
    }
}
