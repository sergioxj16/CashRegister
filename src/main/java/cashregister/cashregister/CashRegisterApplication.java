package cashregister.cashregister;

import classes.Inventory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main application class for the Cash Register.
 */
public class CashRegisterApplication extends Application {

    /**
     * Starts the Cash Register application.
     *
     * @param stage The primary stage for this application.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CashRegisterApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 500);
        stage.setScene(scene);
        stage.setFullScreen(false);
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.show();
    }
}
