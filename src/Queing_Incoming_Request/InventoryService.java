package Queing_Incoming_Request;

import Queing_Incoming_Request.model.InventoryItem;
import Queing_Incoming_Request.model.Request;

import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private Map<String, InventoryItem> inventory = new HashMap<>();

    public void addItem(String itemId, int quantity) {
        inventory.put(itemId, new InventoryItem(itemId, quantity));
    }

    public void process(Request request) {

        InventoryItem item = inventory.get(request.getItemId());

        if (item == null) {
            throw new RuntimeException("Item not found");
        }

        switch (request.getType()) {

            case ADD_STOCK:
                item.addStock(request.getQuantity());
                break;

            case REMOVE_STOCK, RESERVE_STOCK:
                item.removeStock(request.getQuantity());
                break;
        }

        System.out.println("Processed request: " + request.getRequestId());
    }
}