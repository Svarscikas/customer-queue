package com.example.customerqueue.customer.queue;

import com.example.customerqueue.customer.queue.api.CustomerQueue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

@Component
public class CustomerQueueImpl implements CustomerQueue {
    private final BlockingQueue<String> blockingQueue;

    public CustomerQueueImpl() {
        this.blockingQueue = new PriorityBlockingQueue<>();
    }

    public String get() {
        return blockingQueue.poll();
    }

    public void put(String customerNumber) {
        blockingQueue.offer(customerNumber);
    }

    public List<String> other() {
        return new ArrayList<>(blockingQueue);
    }

    public String peek() {
        return blockingQueue.peek();
    }

    @Override
    public int queueSize() {
        return blockingQueue.size();
    }

    @Override
    public int indexOf(String customerNumber) {
        return blockingQueue.stream().toList().indexOf(customerNumber);
    }

    @Override
    public String last() {
        List<String> list = blockingQueue.stream().toList();
        return list.isEmpty() ? null : list.get(blockingQueue.size()-1);
    }
}
