package classes;

import java.io.Serializable;

/**
 * Represents a product with a code, name, buy price, sale price, stock, and sold stock.
 */
public class Product implements Serializable {
    protected String code;
    protected String name;
    protected double buyPrice;
    protected double salePrice;
    protected int stock;
    protected int soldStock;

    /**
     * Constructs a new Product object with the specified code, name, buy price, sale price, and initial stock.
     *
     * @param code         The code of the product.
     * @param name         The name of the product.
     * @param buyPrice     The buy price of the product.
     * @param salePrice    The sale price of the product.
     * @param initialStock The initial stock of the product.
     */
    public Product(String code, String name, double buyPrice, double salePrice, int initialStock) {
        this.code = code;
        this.name = name;
        this.buyPrice = buyPrice;
        this.salePrice = salePrice;
        this.stock = initialStock;
        this.soldStock = 0;
    }

    /**
     * Retrieves the code of the product.
     *
     * @return The code of the product.
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the code of the product.
     *
     * @param code The code of the product.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Retrieves the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the buy price of the product.
     *
     * @return The buy price of the product.
     */
    public double getBuyPrice() {
        return buyPrice;
    }

    /**
     * Sets the buy price of the product.
     *
     * @param buyPrice The buy price of the product.
     */
    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * Retrieves the sale price of the product.
     *
     * @return The sale price of the product.
     */
    public double getSalePrice() {
        return salePrice;
    }

    /**
     * Sets the sale price of the product.
     *
     * @param salePrice The sale price of the product.
     */
    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * Retrieves the current stock of the product.
     *
     * @return The current stock of the product.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Sets the current stock of the product.
     *
     * @param stock The current stock of the product.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Retrieves the amount of stock that has been sold.
     *
     * @return The amount of stock that has been sold.
     */
    public int getSoldStock() {
        return soldStock;
    }

    /**
     * Sets the amount of stock that has been sold.
     *
     * @param soldStock The amount of stock that has been sold.
     */
    public void setSoldStock(int soldStock) {
        this.soldStock = soldStock;
    }
}
