package com.example.customerqueue.customer.rest.api;

public class QueueItemModel {
    private final String customerNumber;

    public QueueItemModel(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }
}
