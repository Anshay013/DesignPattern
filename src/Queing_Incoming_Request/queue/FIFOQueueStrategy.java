package Queing_Incoming_Request.queue;

import Queing_Incoming_Request.model.Request;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOQueueStrategy implements QueueStrategy {

    private Queue<Request> queue = new LinkedList<>();

    @Override
    public void addRequest(Request request) {
        queue.offer(request);
    }

    @Override
    public Request getNextRequest() {
        return queue.poll();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}