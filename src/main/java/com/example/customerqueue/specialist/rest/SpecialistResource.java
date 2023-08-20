package com.example.customerqueue.specialist.rest;

import com.example.customerqueue.customer.queue.api.CustomerQueue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecialistResource {

    private final CustomerQueue customerQueue;

    public SpecialistResource(CustomerQueue customerQueue) {
        this.customerQueue = customerQueue;
    }

    @GetMapping("/specialist/customer")
    public String getCustomerNumber() {
        return customerQueue.get();
    }
}
