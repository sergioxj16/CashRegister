package classes;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a sale with a sale code, list of products, total amount, and sale date.
 */
public class Sale {
    private String saleCode;
    private List<Product> productList;
    private double total;
    private LocalDateTime date;

    /**
     * Constructs a new Sale object with the specified sale code, list of products, total amount, and sale date.
     *
     * @param saleCode    The sale code.
     * @param productList The list of products sold.
     * @param total       The total amount of the sale.
     * @param date        The date and time of the sale.
     */
    public Sale(String saleCode, List<Product> productList, double total, LocalDateTime date) {
        this.saleCode = saleCode;
        this.productList = productList;
        this.total = total;
        this.date = date;
    }

    /**
     * Retrieves the sale code.
     *
     * @return The sale code.
     */
    public String getSaleCode() {
        return saleCode;
    }

    /**
     * Sets the sale code.
     *
     * @param saleCode The sale code.
     */
    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    /**
     * Retrieves the list of products sold in the sale.
     *
     * @return The list of products.
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * Sets the list of products sold in the sale.
     *
     * @param productList The list of products.
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * Retrieves the total amount of the sale.
     *
     * @return The total amount.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Sets the total amount of the sale.
     *
     * @param total The total amount.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Retrieves the date and time of the sale.
     *
     * @return The date and time.
     */
    public LocalDateTime getDate() {
        return date;
    }

    /**
     * Sets the date and time of the sale.
     *
     * @param date The date and time.
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

