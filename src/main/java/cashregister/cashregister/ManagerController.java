package cashregister.cashregister;

import classes.UserManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Map;
import javafx.stage.Stage;


public class ManagerController {

    @FXML
    private TextField createUserUsernameField;

    @FXML
    private TextField createUserPasswordField;

    @FXML
    private TextField createUserRepeatPasswordField;

    @FXML
    private TextField deleteUserUsernameField;

    @FXML
    private TextField confirmField;

    @FXML
    private ListView<String> usersListView;

    @FXML
    private Button backButton;

    private UserManager userManager;

    public void initialize() {
        userManager = new UserManager();
        refreshUserListView();
    }

    @FXML
    private void createUserButton() {
        String username = createUserUsernameField.getText();
        String password = createUserPasswordField.getText();
        String repeatedPassword = createUserRepeatPasswordField.getText();

        if (username.isEmpty() || password.isEmpty() || repeatedPassword.isEmpty()) {
            showAlert("Error", "Please fill all fields.");
        }
        else if (!password.equals(repeatedPassword)) {
            showAlert("Error", "Passwords do not match.");
        }
        else{
            userManager.addUser(username, password);
            showAlert("Success", "User '" + username + "' created successfully.");
            refreshUserListView();
        }
    }

    @FXML
    private void deleteUserButton() {
        String usernameToDelete = deleteUserUsernameField.getText();
        String validation = confirmField.getText();
        if (usernameToDelete.isEmpty()) {
            showAlert("Error", "Please enter the username to delete.");
        }
        else if (!userManager.findUser(usernameToDelete))
        {
            showAlert("Error", "User name not exist.");
        }
        else if (!validation.equals("CONFIRM")) {
            showAlert("Error", "Please confirm deletion by typing 'CONFIRM'.");
        }
        else {
            userManager.deleteUser(usernameToDelete);
            showAlert("Success", "User '"+  usernameToDelete + "' deleted successfully.");
            refreshUserListView();
        }
    }

    @FXML
    private void refreshButton() {
        refreshUserListView();
    }
    private void refreshUserListView() {
        ObservableList<String> items = FXCollections.observableArrayList();
        Map<String, String> users = userManager.getUsers();
        for (Map.Entry<String, String> entry : users.entrySet()) {
            String username = entry.getKey();
            String password = entry.getValue();
            items.add("Username: " + username + ", Password: " + password);
        }
        usersListView.setItems(items);
    }

    @FXML
    private void backButton() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
