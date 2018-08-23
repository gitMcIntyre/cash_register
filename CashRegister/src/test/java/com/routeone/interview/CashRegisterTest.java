package com.routeone.interview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CashRegisterTest {

	Register reg = new StoreRegister();

	@Before
	public void setup() {
		ClassLoader loader = getClass().getClassLoader();
		URL url = loader.getResource("sample-inventory.csv");
		File f = new File(url.getFile());
		
		reg.loadInventory(f);
	}
	
	@Test
	public void test_1_item() {
		String total = "$20.00";
		List<String> expected = new ArrayList<>(Arrays.asList("PC1033"));
		
		List<String> items = new ArrayList<>(Arrays.asList("PC1033"));
		
		Receipt r = reg.checkoutOrder(items);
		
		assertTrue(r.getFormattedTotal().equalsIgnoreCase(total));
		assertEquals(r.getOrderedItems(), expected);
		
	}
	
	@Test
	public void test_2_items_by_price() {
		String total = "$29.99";
		
		// items for $20 and $9.99 respectively
		List<String> items = new ArrayList<>(Arrays.asList("PC1033", "PC800"));
		
		Receipt r = reg.checkoutOrder(items);
		
		List<String> expected = new ArrayList<>(Arrays.asList("PC800", "PC1033"));
		
		assertTrue(r.getFormattedTotal().equalsIgnoreCase(total));
		assertEquals(r.getOrderedItems(), expected);
		
	}

	@Test
	public void test_full_sort() {
		String total = "$179.99";
		
		List<String> expected = new ArrayList<>(Arrays.asList("PC800", "PC1033", "LCD", "LCD2"));
		
		List<String> items = new ArrayList<>(Arrays.asList("PC1033", "PC800", "LCD2", "LCD")); //20, 9.99, 75, 75
		
		Receipt r = reg.checkoutOrder(items);
		
		assertTrue(r.getFormattedTotal().equalsIgnoreCase(total));
		assertEquals(r.getOrderedItems(), expected);
		
	}

}
