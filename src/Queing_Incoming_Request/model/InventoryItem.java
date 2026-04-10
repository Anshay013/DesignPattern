package Queing_Incoming_Request.model;

public class InventoryItem {

    private String itemId;
    private int quantity;

    public InventoryItem(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addStock(int qty) {
        quantity += qty;
    }

    public void removeStock(int qty) {
        if (quantity < qty) {
            throw new RuntimeException("Insufficient inventory");
        }
        quantity -= qty;
    }
}
