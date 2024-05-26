package cashregister.cashregister;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller class for managing the sale view.
 */
public class SaleController {

    @FXML
    private Button backButton;

    /**
     * Handles the action when the user clicks the back button.
     * Closes the current stage.
     */
    @FXML
    private void backButtonOnclick() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }
}
