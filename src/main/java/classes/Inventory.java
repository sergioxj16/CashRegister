package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.*;
import java.util.*;

/**
 * Represents an inventory of products.
 */
public class Inventory {
    // Map to store products with their corresponding product code and stock quantity
    private Map<String, Product> productMap;

    private final String FILE_PATH = "src/main/data/products.txt";

    /**
     * Constructs a new Inventory object.
     */
    public Inventory() {
        // Using HashMap to store products and their stock quantities
        this.productMap = new HashMap<>();
    }

    /**
     * Retrieves the product map.
     *
     * @return The product map.
     */
    public Map<String, Product> getProductMap() {
        return productMap;
    }

    /**
     * Adds a product to the inventory with initial stock.
     *
     * @param product      The product to add.
     * @param initialStock The initial stock quantity of the product.
     */
    public void addProduct(Product product, int initialStock) {
        // Set the product's initial stock quantity
        product.setStock(initialStock);
        // Add the product to the productMap with product code as key
        productMap.put(product.getCode(), product);
    }

    /**
     * Deletes a product from the inventory based on its product code.
     *
     * @param productCode The code of the product to delete.
     * @return true if the product was successfully deleted, false otherwise.
     */
    public boolean deleteProduct(String productCode) {
        if (productMap.containsKey(productCode)) {
            productMap.remove(productCode);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a list of all products in the inventory.
     *
     * @return A list of all products in the inventory.
     */
    public List<Product> getProducts() {
        return new ArrayList<>(productMap.values());
    }

    /**
     * Retrieves the stock quantity of a product with the specified code.
     *
     * @param productCode The code of the product.
     * @return The stock quantity of the product.
     */
    public int getStock(String productCode) {
        // Get the product from the productMap using the product code
        Product product = productMap.get(productCode);
        // If product is found, return its stock quantity; otherwise, return 0
        return (product != null) ? product.getStock() : 0;
    }

    /**
     * Adds the specified quantity of a product to the inventory stock.
     *
     * @param productCode The code of the product.
     * @param quantity    The quantity to add.
     */
    public void addToStock(String productCode, int quantity) {
        // Get the product from the productMap using the product code
        Product product = productMap.get(productCode);
        // If product is found, increase its stock quantity by the specified quantity
        if (product != null) {
            int currentStock = product.getStock();
            product.setStock(currentStock + quantity);
        }
    }

    /**
     * Removes the specified quantity of a product from the inventory stock.
     *
     * @param productCode The code of the product.
     * @param quantity    The quantity to remove.
     */
    public void removeFromStock(String productCode, int quantity) {
        // Get the product from the productMap using the product code
        Product product = productMap.get(productCode);
        // If product is found, decrease its stock quantity by the specified quantity
        if (product != null) {
            int currentStock = product.getStock();
            // Ensure the stock quantity doesn't go below 0
            int newStock = Math.max(0, currentStock - quantity);
            product.setStock(newStock);
        }
    }

    /**
     * Saves the current state of the inventory to a file.
     */
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Product product : productMap.values()) {
                writer.println(product.getCode() + ";" +
                        product.getName() + ";" +
                        product.getBuyPrice() + ";" +
                        product.getSalePrice() + ";" +
                        product.getStock());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the inventory from a file.
     */
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    String code = parts[0];
                    String name = parts[1];
                    double buyPrice = Double.parseDouble(parts[2]);
                    double salePrice = Double.parseDouble(parts[3]);
                    int stock = Integer.parseInt(parts[4]);
                    Product product = new Product(code, name, buyPrice, salePrice, stock);
                    productMap.put(code, product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
