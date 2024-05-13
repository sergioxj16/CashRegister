package classes;

/**
 * Represents a user with a name and password.
 */
public class User {
    private String name;
    private String password;

    /**
     * Constructs a new User object with the specified name and password.
     *
     * @param name     The name of the user.
     * @param password The password of the user.
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * Retrieves the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name The name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}


