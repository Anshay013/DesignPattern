package Queing_Incoming_Request.queue;

import Queing_Incoming_Request.model.Request;

public interface QueueStrategy {

    void addRequest(Request request);

    Request getNextRequest();

    boolean isEmpty();
}
