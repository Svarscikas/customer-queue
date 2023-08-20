package com.example.customerqueue.customer.rest.api;

public class TimeToQueue {
    private String customerNumber;

    private int estimatedTimeToQueue;

    private int positionInQueue;

    public TimeToQueue(String customerNumber, int estimatedTimeToQueue, int positionInQueue) {
        this.customerNumber = customerNumber;
        this.estimatedTimeToQueue = estimatedTimeToQueue;
        this.positionInQueue = positionInQueue;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getEstimatedTimeToQueue() {
        return estimatedTimeToQueue;
    }

    public void setEstimatedTimeToQueue(int estimatedTimeToQueue) {
        this.estimatedTimeToQueue = estimatedTimeToQueue;
    }

    public int getPositionInQueue() {
        return positionInQueue;
    }
}
