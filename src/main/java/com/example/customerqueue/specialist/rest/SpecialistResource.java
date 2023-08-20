package com.example.customerqueue.specialist.rest;

import com.example.customerqueue.customer.queue.api.CustomerQueue;
import com.example.customerqueue.customer.rest.api.QueueItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecialistResource {

    private final CustomerQueue customerQueue;

    public SpecialistResource(CustomerQueue customerQueue) {
        this.customerQueue = customerQueue;
    }

    @GetMapping("/specialist")
    public QueueItem getCustomerNumber() {

        return new QueueItem(customerQueue.get());
    }
}
