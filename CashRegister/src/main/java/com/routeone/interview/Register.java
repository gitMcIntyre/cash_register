package com.routeone.interview;

import java.io.File;
import java.util.List;

/**
 * Defines the methods that support loading an inventory of items
 * and determining the a Receipt for a list of items based on the inventory.
 *  
 * @author dmcintyre
 *
 */
public interface Register {
	
	/**
	 * Load the items from the inventory file.
	 * 
	 * @param inventoryFile
	 * 		the File to load
	 */
	public void loadInventory(File inventoryFile);

	/**
	 * Return a receipt for the list of item names.
	 * @param items
	 * 		the names of the items
	 * @return
	 * 		A Receipt for the named items.
	 */
	public Receipt checkoutOrder(List<String> items);

}