package cashregister.cashregister;

import classes.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button loginButton;

    @FXML
    private TextField userTextBox;

    @FXML
    private PasswordField passwordTextBox;

    private UserManager userManager;

    public LoginController() {
        userManager = new UserManager();
    }

    @FXML
    protected void loginButtonOnclick(ActionEvent event) {
        String username = userTextBox.getText();
        String password = passwordTextBox.getText();

        try {
            if (userManager.getUsers().containsKey(username) && userManager.getUsers().get(username).equals(password)) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu-view.fxml"));
                Parent root = loader.load();

                MenuController controller = loader.getController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setFullScreen(false);
                stage.setMaximized(false);
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.show();

                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();
            } else {
                showErrorAlert("Login Failed", "User or password incorrect");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void showErrorAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
