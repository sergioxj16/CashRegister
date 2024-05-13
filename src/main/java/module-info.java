module cashregister.cashregister {
    requires javafx.controls;
    requires javafx.fxml;


    opens cashregister.cashregister to javafx.fxml;
    exports cashregister.cashregister;
}