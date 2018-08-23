package com.routeone.interview;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Receipt implementation that maintains a list of Item objects.
 * The total price can be determined and the list of items sold can be retrieved.
 * 
 * @author dmcintyre
 *
 */
public class ReceiptImpl implements Receipt {

	List<Item> items = new ArrayList<>();
	
	public void addItem(Item item) {
		if(Objects.nonNull(item)) {
			items.add(item);
		}
	}
	
	/**
	 * Return the formatted total of all the item prices.
	 * Format: $#,###.##
	 */
	@Override
	public String getFormattedTotal() {
		Double d = items.stream() 
				.collect(Collectors.summingDouble(i -> i.getValue()));
		
		return NumberFormat.getCurrencyInstance(new Locale("en", "US"))
		        .format(d);

	}

	@Override
	public List<String> getOrderedItems() {
		//sort by price then by name.
		Comparator<Item> byPrice = (e1, e2) -> e1.getValue().compareTo(e2.getValue());
		Comparator<Item> byName = (e1,e2) -> e1.getName().compareTo(e2.getName());
		Comparator<Item> byPriceAndName = byPrice.thenComparing(byName);
		return items.stream().sorted(byPriceAndName).map(n -> n.getName()).collect(Collectors.toList());
	}

}
