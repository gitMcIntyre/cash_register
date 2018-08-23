package com.routeone.interview;
import java.util.List;

/**
 * Purpose to define the methods to support working with item receipts.
 * A Receipt can contain any number of items.
 * 
 * @author dmcintyre
 *
 */
public interface Receipt {
	
	/**
	 * Add an item to the receipt
	 * @param item
	 * 		the Item to add
	 */
	public void addItem(Item item);
	
    /**
     * @return Currency formatted total ($X.XX) of all items
     */
    public String getFormattedTotal();
 
    /**
     * @return List of all items in descending order by amount
     */
    public List<String> getOrderedItems();
}