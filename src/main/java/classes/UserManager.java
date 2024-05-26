package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages users by storing them in a dictionary with usernames as keys and passwords as values.
 */
public class UserManager {
    private static final String User_File = "src/main/data/users.txt";
    private Map<String, String> users;

    /**
     * Constructs a new UserManager object.
     */
    public UserManager() {
        this.users = new HashMap<>();
        loadUsersFile();
    }

    /**
     * Loads users and passwords from a file.
     *
     * @param User_File The path to the file containing users and passwords.
     */
    private void loadUsersFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(User_File))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    users.put(username, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new user to the user dictionary.
     *
     * @param username The username of the new user.
     * @param password The password of the new user.
     */
    public void addUser(String username, String password) {
        if (!users.containsKey(username)) {
            users.put(username, password);
            updateUserFile();
        } else {
            System.out.println("Username already exists!");
        }
    }

    /**
     * Deletes a user from the user dictionary.
     *
     * @param userName The username of the user to be deleted.
     */
    public void deleteUser(String userName) {
        if (users.containsKey(userName)) {
            users.remove(userName);
            updateUserFile();
        }
    }

    /**
     * Finds a user in the user dictionary.
     *
     * @param userName The username of the user to be found.
     * @return true if the user exists, false otherwise.
     */
    public boolean findUser(String userName) {
        return users.containsKey(userName);
    }

    /**
     * Writes updated user information to the file.
     */
    public void updateUserFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(User_File))) {
            for (Map.Entry<String, String> entry : users.entrySet()) {
                writer.write(entry.getKey() + ";" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the dictionary of users.
     *
     * @return The dictionary of users.
     */
    public Map<String, String> getUsers() {
        return users;
    }
}
