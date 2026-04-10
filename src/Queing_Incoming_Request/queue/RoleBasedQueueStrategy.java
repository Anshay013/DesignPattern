package Queing_Incoming_Request.queue;

import Queing_Incoming_Request.model.Request;

import java.util.PriorityQueue;

public class RoleBasedQueueStrategy implements QueueStrategy {

    private PriorityQueue<Request> pq =
            new PriorityQueue<>(
                    (a, b) -> rolePriority(b) - rolePriority(a)
            );

    private int rolePriority(Request r) {

        return switch (r.getRole()) {
            case ADMIN -> 3;
            case SELLER -> 2;
            case USER -> 1;
        };

    }

    @Override
    public void addRequest(Request request) {
        pq.offer(request);
    }

    @Override
    public Request getNextRequest() {
        return pq.poll();
    }

    @Override
    public boolean isEmpty() {
        return pq.isEmpty();
    }
}
