module cashregister.cashregister {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    opens cashregister.cashregister to javafx.fxml;
    exports cashregister.cashregister;
}
