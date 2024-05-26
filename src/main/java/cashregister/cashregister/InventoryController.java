package cashregister.cashregister;

import classes.Inventory;
import classes.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for managing inventory-related actions.
 */
public class InventoryController implements Initializable {

    @FXML
    private TextField addCode;
    @FXML
    private TextField addName;
    @FXML
    private TextField addBuyprice;
    @FXML
    private TextField addSalePrice;
    @FXML
    private TextField addInitialStock;
    @FXML
    private TextField deleteCode;
    @FXML
    private TextField addStockCode;
    @FXML
    private TextField addStockQuantity;
    @FXML
    private Button addStockButton;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, String> tableViewCode;
    @FXML
    private TableColumn<Product, String> tableViewName;
    @FXML
    private TableColumn<Product, Double> tableViewSalePrice;
    @FXML
    private TableColumn<Product, Double> tableViewBuyPrice;
    @FXML
    private TableColumn<Product, Integer> tableViewStock;
    @FXML
    private Button backButton;

    private ObservableList<Product> products;

    private final Inventory inventory;

    /**
     * Constructor for InventoryController.
     */
    public InventoryController() {
        this.inventory = new Inventory();
    }

    /**
     * Initializes the inventory view.
     *
     * @param url The location used to resolve relative paths for the root object, or null if the location is not known.
     * @param rb  The resources used to localize the root object, or null if the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        products = FXCollections.observableArrayList();
        productTable.setItems(products);
        inventory.loadFromFile();
        tableViewCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        tableViewName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableViewStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        tableViewBuyPrice.setCellValueFactory(new PropertyValueFactory<>("buyPrice"));
        tableViewSalePrice.setCellValueFactory(new PropertyValueFactory<>("salePrice"));
        refreshTable();
    }

    @FXML
    private void addProductButtonOnclik(ActionEvent event) {
        String code = addCode.getText();
        String name = addName.getText();
        double buyPrice = 0.0;
        double salePrice = 0.0;
        int stock = 0;
        boolean numError = false;

        try {
            stock = Integer.parseInt((addInitialStock.getText()));
            buyPrice = Double.parseDouble(addBuyprice.getText());
            salePrice = Double.parseDouble(addSalePrice.getText());
        } catch (NumberFormatException e) {
            numError = true;
            showAlert("Invalid number", "Check numbers.");
        }
        if (inventory.getProductMap().containsKey(code)) {
            showAlert("Product already exists", "A product with the same code already exists.");
        }
        if (!inventory.getProductMap().containsKey(code) && !numError) {
            Product product = new Product(code, name, buyPrice, salePrice, stock);
            inventory.addProduct(product, 0);
            inventory.saveToFile();
            addCode.clear();
            addName.clear();
            addBuyprice.clear();
            addSalePrice.clear();
            addInitialStock.clear();
            refreshTable();
            showAlert("Success", "Product added to inventory successfully.");
        }

    }

    @FXML
    private void deleteProductButtonOnclik(ActionEvent event) {
        String productCode = deleteCode.getText();

        if (productCode.isEmpty()) { // Check if the product code is empty
            showAlert("Error", "Please enter the product code.");
        } else if (!inventory.getProductMap().containsKey(productCode)) {
            showAlert("Product not exists", "Wrong code or not exit");
        } else {
            inventory.deleteProduct(productCode);
            inventory.saveToFile();
            showAlert("Success", "Product deleted successfully.");
            deleteCode.clear();
            refreshTable();
        }
    }

    @FXML
    private void addStockButtonOnclik(ActionEvent event) {
        int quantity = Integer.parseInt(addStockQuantity.getText());
        String code = addStockCode.getText();

        if (code.isEmpty()) {
            showAlert("Error", "Please enter the product code.");
        } else if (inventory.getProductMap().containsKey(code)) {
            inventory.addToStock(code, quantity);
            inventory.saveToFile();
            showAlert("successful", "Stock added successfully");
            refreshTable();
        } else {
            showAlert("Product not exists", "Wrong code or not exit");
        }

    }

    @FXML
    private void refreshTable() {
        ObservableList<Product> products = FXCollections.observableArrayList(inventory.getProducts());
        productTable.setItems(products);
    }

    @FXML
    private void refreshTableOnClick(ActionEvent event) {
        refreshTable();
    }

    @FXML
    private void backButtonOnclik() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Shows an alert dialog.
     *
     * @param title   The title of the alert.
     * @param message The content message of the alert.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
