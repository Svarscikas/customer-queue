package com.example.customerqueue.customer.queue.api;

import java.util.List;

public interface CustomerQueue {
    void put(String customerNumber);

    public List<String> other();

    String get();

    String peek();
}
