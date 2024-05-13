package classes;

/**
 * Represents a product with a code, name, buy price, and sale price.
 */
public class Product {
    private String code;
    private String name;
    private double buyPrice;
    private double salePrice;

    /**
     * Constructs a new Product object with the specified code, name, buy price, and sale price.
     *
     * @param code      The code of the product.
     * @param name      The name of the product.
     * @param buyPrice  The buy price of the product.
     * @param salePrice The sale price of the product.
     */
    public Product(String code, String name, double buyPrice, double salePrice) {
        this.code = code;
        this.name = name;
        this.buyPrice = buyPrice;
        this.salePrice = salePrice;
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
}
