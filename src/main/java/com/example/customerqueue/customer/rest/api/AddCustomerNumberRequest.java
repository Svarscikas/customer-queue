package com.example.customerqueue.customer.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddCustomerNumberRequest {

    @JsonProperty
    private String customerNumber;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
