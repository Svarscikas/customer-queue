package com.example.customerqueue.customer.rest.api;

public class QueueItem {
    private final String customerNumber;

    public QueueItem(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }
}
