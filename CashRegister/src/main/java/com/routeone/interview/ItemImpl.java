package com.routeone.interview;

public class ItemImpl implements Item {
	private String name;
	private String price;
	private String category;

	/**
	 * Default constructor
	 * @param name
	 * 		the name of the item
	 * @param price
	 * 		the string representation for the item price
	 * 		For example "20" or "5.99"
	 * @param category
	 * 		the item category
	 */
	public ItemImpl(String name, String price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPrice() {
		return price;
	}

	@Override
	public Float getValue() {
		return new Float(price);
	}
	
	@Override
	public String getCategory() {
		return category;
	}

}
