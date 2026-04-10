package Queing_Incoming_Request.model;

import Queing_Incoming_Request.RequestType;
import Queing_Incoming_Request.Role;

import java.time.Instant;

public class Request {

    private String requestId;
    private String itemId;
    private RequestType type;
    private int quantity;
    private int importanceLevel;
    private Role role;
    private long timestamp;

    public Request(String requestId,
                   String itemId,
                   RequestType type,
                   int quantity,
                   int importanceLevel,
                   Role role) {

        this.requestId = requestId;
        this.itemId = itemId;
        this.type = type;
        this.quantity = quantity;
        this.importanceLevel = importanceLevel;
        this.role = role;
        this.timestamp = Instant.now().toEpochMilli();
    }

    public String getRequestId() { return requestId; }

    public String getItemId() { return itemId; }

    public RequestType getType() { return type; }

    public int getQuantity() { return quantity; }

    public int getImportanceLevel() { return importanceLevel; }

    public Role getRole() { return role; }

    public long getTimestamp() { return timestamp; }
}
