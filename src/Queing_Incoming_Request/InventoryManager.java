package Queing_Incoming_Request;

import Queing_Incoming_Request.model.Request;
import Queing_Incoming_Request.queue.QueueStrategy;

public class InventoryManager{

    private QueueStrategy strategy;
    private InventoryService inventoryService;

    public InventoryManager(QueueStrategy strategy,
                              InventoryService inventoryService) {

        this.strategy = strategy;
        this.inventoryService = inventoryService;
    }

    public void submitRequest(Request request) {
        strategy.addRequest(request);
    }

    public void processNext() {

        Request request = strategy.getNextRequest();

        if (request != null) {
            inventoryService.process(request);
        }
    }

    public void processAll() {

        while (!strategy.isEmpty()) {
            processNext();
        }
    }

    public void setStrategy(QueueStrategy strategy) {
        this.strategy = strategy;
    }
}
