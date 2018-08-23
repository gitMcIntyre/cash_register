package com.routeone.interview;

/**
 * Purpose to define the methods to support working with inventory items.
 * 
 * @author dmcintyre
 *
 */
public interface Item {
	
	public String getName();
	
	public String getPrice();
	
	public String getCategory();
	
	/**
	 * @return
	 * 		the Float representation for the price
	 */
	public Float getValue();
}
