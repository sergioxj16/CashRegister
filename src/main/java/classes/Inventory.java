package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents an inventory of products.
 */
public class Inventory {
    private List<Product> productList;
    private Map<String, Integer> stock;

    /**
     * Constructs a new Inventory object.
     */
    public Inventory() {
        this.productList = new ArrayList<>();
        this.stock = new HashMap<>();
    }

    /**
     * Adds a product to the inventory.
     *
     * @param product The product to add.
     */
    public void addProduct(Product product) {
        productList.add(product);
    }

    /**
     * Retrieves the list of products in the inventory.
     *
     * @return The list of products.
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * Adds the specified quantity of a product to the inventory stock.
     *
     * @param productCode The code of the product.
     * @param quantity    The quantity to add.
     */
    public void addToStock(String productCode, int quantity) {
        stock.put(productCode, stock.getOrDefault(productCode, 0) + quantity);
    }

    /**
     * Removes the specified quantity of a product from the inventory stock.
     *
     * @param productCode The code of the product.
     * @param quantity    The quantity to remove.
     */
    public void removeFromStock(String productCode, int quantity) {
        int currentStock = stock.getOrDefault(productCode, 0);
        int newStock = Math.max(0, currentStock - quantity);
        stock.put(productCode, newStock);
    }

    /**
     * Retrieves the stock quantity of a product with the specified code.
     *
     * @param productCode The code of the product.
     * @return The stock quantity of the product.
     */
    public int getStock(String productCode) {
        return stock.getOrDefault(productCode, 0);
    }

    /**
     * Retrieves the entire stock as a mapping of product codes to stock quantities.
     *
     * @return The stock mapping.
     */
    public Map<String, Integer> getStock() {
        return stock;
    }
}
