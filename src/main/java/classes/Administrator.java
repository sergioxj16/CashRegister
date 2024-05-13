package classes;

/**
 * Represents an administrator, inheriting properties from the User class.
 */
public class Administrator extends User {
    /**
     * Constructs a new Administrator object with the specified name and password.
     *
     * @param name     The name of the administrator.
     * @param password The password of the administrator.
     */
    public Administrator(String name, String password) {
        super(name, password);
    }

    // Additional methods specific to administrators can be added here
}

