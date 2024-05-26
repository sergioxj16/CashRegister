package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sale history containing a list of sales.
 */
public class SaleHistory {
    private List<Sale> saleList;

    /**
     * Constructs a new SaleHistory object with an empty list of sales.
     */
    public SaleHistory() {
        this.saleList = new ArrayList<>();
    }

    /**
     * Retrieves the list of sales in the sale history.
     *
     * @return The list of sales.
     */
    public List<Sale> getSaleList() {
        return saleList;
    }

    /**
     * Adds a sale to the sale history.
     *
     * @param sale The sale to add.
     */
    public void addSale(Sale sale) {
        saleList.add(sale);
    }

    /**
     * Removes a sale from the sale history.
     *
     * @param sale The sale to remove.
     */
    public void removeSale(Sale sale) {
        saleList.remove(sale);
    }

    /**
     * Removes all sales from the sale history.
     */
    public void clear() {
        saleList.clear();
    }
}
