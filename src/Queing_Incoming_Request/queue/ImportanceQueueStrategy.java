package Queing_Incoming_Request.queue;

import Queing_Incoming_Request.model.Request;

import java.util.PriorityQueue;

public class ImportanceQueueStrategy implements QueueStrategy {

    private PriorityQueue<Request> pq =
            new PriorityQueue<>(
                    (a, b) -> b.getImportanceLevel() - a.getImportanceLevel()
            );

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
