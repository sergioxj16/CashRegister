package classes;

/**
 * Represents a standard user, inheriting properties from the User class.
 */
public class StandartUser extends User {
    /**
     * Constructs a new StandardUser object with the specified name and password.
     *
     * @param name     The name of the standard user.
     * @param password The password of the standard user.
     */
    public StandartUser(String name, String password) {
        super(name, password);
    }

}

