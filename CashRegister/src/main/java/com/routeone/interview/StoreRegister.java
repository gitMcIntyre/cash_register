package com.routeone.interview;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class StoreRegister implements Register {
	Map<String, Item> inventory;
	
    /* (non-Javadoc)
	 * @see com.routeone.interview.Register#loadInventory(java.io.File)
	 */
    @Override
	public void loadInventory(File inventoryFile){
    	//reset the inventory map
    	inventory = new HashMap<>();
    	if(inventoryFile.exists()) {
    		try {
    			
				Files.readAllLines(inventoryFile.toPath())
				.forEach(this :: createItem);
			} catch (IOException e) {
				//TODO: add logging
				e.printStackTrace();
			}
    	}
		
    }
 
    /* (non-Javadoc)
	 * @see com.routeone.interview.Register#checkoutOrder(java.util.List)
	 */
    @Override
	public Receipt checkoutOrder(List<String> items) {
    	Receipt r = new ReceiptImpl();
		
    	if(Objects.nonNull(items)) {
    		items.stream().forEach(l -> this.addToReceipt(l, r));
    		
    		
    	}
    	
        return r;
    }
    
    private void addToReceipt(String itemName, Receipt r) {
    	Item i = inventory.get(itemName);
    	if(Objects.nonNull(i)) {
    		r.addItem(i);
    	}
    }
    
    private void createItem(String line){
    	String[] i = line.split(",");
    	inventory.put(i[0], new ItemImpl(i[0], i[1], i[2]));
    }
}
