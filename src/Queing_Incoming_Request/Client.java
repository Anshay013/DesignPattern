package Queing_Incoming_Request;

import Queing_Incoming_Request.model.Request;
import Queing_Incoming_Request.queue.FIFOQueueStrategy;
import Queing_Incoming_Request.queue.QueueStrategy;

public class Client {

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryService();

        inventoryService.addItem("item1", 100);

        QueueStrategy strategy = new FIFOQueueStrategy();

        InventoryManager manager =
                new InventoryManager(strategy, inventoryService);


        // manager.setStrategy(strategy);

        Request r1 = new Request(
                "R1",
                "item1",
                RequestType.REMOVE_STOCK,
                10,
                5,
                Role.USER
        );

        Request r2 = new Request(
                "R2",
                "item1",
                RequestType.ADD_STOCK,
                20,
                10,
                Role.ADMIN
        );

        Request r3 = new Request(
                "R3",
                "item1",
                RequestType.REMOVE_STOCK,
                5,
                2,
                Role.SELLER
        );

        manager.submitRequest(r1);
        manager.submitRequest(r2);
        manager.submitRequest(r3);

        manager.processAll();
    }
}
