package com.example.customerqueue.customer.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomerDashboard {

    @JsonProperty
    private String currentQueueNumber;

    private List<String> nextQueueNumbers;

    public CustomerDashboard(String currentQueueNumber, List<String> nextQueueNumbers) {
        this.currentQueueNumber = currentQueueNumber;
        this.nextQueueNumbers = nextQueueNumbers;
    }

    public String getCurrentQueueNumber() {
        return currentQueueNumber;
    }

    public List<String> getNextQueueNumbers() {
        return nextQueueNumbers;
    }
}
