package cashregister.cashregister;

import classes.UserManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

/**
 * Controller class for the manager view.
 */
public class ManagerController {

    @FXML
    private TextField createUserUsernameField; // Text field for entering new user username

    @FXML
    private TextField createUserPasswordField; // Text field for entering new user password

    @FXML
    private TextField createUserRepeatPasswordField; // Text field for confirming new user's password

    @FXML
    private TextField deleteUserUsernameField; // Text field for entering username to delete

    @FXML
    private TextField confirmField; // Text field for confirming user deletion

    @FXML
    private ListView<String> usersListView; // ListView to display existing users

    @FXML
    private Button backButton; // Button to navigate back

    private UserManager userManager; // Instance of UserManager to manage users

    /**
     * Initializes the manager view.
     */
    public void initialize() {
        userManager = new UserManager();
        refreshUserListView(); // Refreshes user list view
    }

    /**
     * Handles the action of creating a new user.
     */
    @FXML
    private void createUserButton() {
        String username = createUserUsernameField.getText();
        String password = createUserPasswordField.getText();
        String repeatedPassword = createUserRepeatPasswordField.getText();

        if (username.isEmpty() || password.isEmpty() || repeatedPassword.isEmpty()) {
            showAlert("Error", "Please fill all fields.");
        } else if (!password.equals(repeatedPassword)) {
            showAlert("Error", "Passwords do not match.");
        } else {
            userManager.addUser(username, password);
            showAlert("Success", "User '" + username + "' created successfully.");
            refreshUserListView();
            createUserUsernameField.clear();
            createUserPasswordField.clear();
            createUserPasswordField.clear();
            createUserRepeatPasswordField.clear();
        }
    }

    /**
     * Handles the action of deleting a user.
     */
    @FXML
    private void deleteUserButton() {
        String usernameToDelete = deleteUserUsernameField.getText();
        String validation = confirmField.getText();
        if (usernameToDelete.isEmpty()) {
            showAlert("Error", "Please enter the username to delete.");
        } else if (!userManager.findUser(usernameToDelete)) {
            showAlert("Error", "User name does not exist.");
        } else if (!validation.equals("CONFIRM")) {
            showAlert("Error", "Please confirm deletion by typing 'CONFIRM'.");
        } else {
            userManager.deleteUser(usernameToDelete);
            showAlert("Success", "User '"+  usernameToDelete + "' deleted successfully.");
            refreshUserListView();
            deleteUserUsernameField.clear();
        }
    }

    /**
     * Handles the action of refreshing the user list.
     */
    @FXML
    private void refreshButton() {
        refreshUserListView();
    }

    /**
     * Refreshes the user list view, show users and passwords
     */
    private void refreshUserListView() {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (String username : userManager.getUsers().keySet()) {
            items.add("Username: " + username + ", Password: " + userManager.getUsers().get(username));
        }
        usersListView.setItems(items);
    }

    /**
     * back to menu
     */
    @FXML
    private void backButton() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Displays an alert with the specified title and message.
     * @param title The title of the alert.
     * @param message The message of the alert.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
