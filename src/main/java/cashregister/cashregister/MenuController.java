package cashregister.cashregister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private Button logOutButton;

    @FXML
    protected void userManagerButtonOnclick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Manager-view.fxml"));
            Parent root = loader.load();

            ManagerController controller = loader.getController();

            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setFullScreen(false);
            stage.setMaximized(false);
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void logOutButtonOnclick(ActionEvent event) {

        Stage currentStage = (Stage) logOutButton.getScene().getWindow();
        currentStage.close();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login-view.fxml"));
            Parent root = loader.load();

            // Set up the new scene and stage
            Scene scene = new Scene(root, 600, 500);
            Stage loginStage = new Stage();
            loginStage.setScene(scene);
            loginStage.setFullScreen(false);
            loginStage.setMaximized(false);
            loginStage.setResizable(false);
            loginStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
