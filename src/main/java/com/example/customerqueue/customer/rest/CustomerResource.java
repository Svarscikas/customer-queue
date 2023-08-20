package com.example.customerqueue.customer.rest;

import com.example.customerqueue.customer.api.CustomerDashboard;
import com.example.customerqueue.customer.queue.api.CustomerQueue;
import com.example.customerqueue.customer.rest.api.AddCustomerNumberRequest;
import com.example.customerqueue.customer.rest.api.QueueItem;
import com.example.customerqueue.customer.rest.api.TimeToQueue;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CustomerResource {

    @Value("${queue-item-process-time}")
    private int queueItemProcessTime;

    @Value("${default-first-customer-number}")
    private String defaultFirstCustomNumber;

    private final CustomerQueue customerQueue;

    public CustomerResource(CustomerQueue customerQueue) {
        this.customerQueue = customerQueue;
    }

    @GetMapping("/customer")
    public CustomerDashboard customerDashboard() {
        String firstInQueue = customerQueue.peek();
        List<String> other = customerQueue.other();

        return new CustomerDashboard(firstInQueue, other);
    }

    @GetMapping("/customer/{customerNumber}")
    public TimeToQueue timeToVisit(@PathVariable("customerNumber") String customerNumber) {
        int indexOf = customerQueue.indexOf(customerNumber);
        if (indexOf < 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "customer number not found"
            );
        }

        int positionInQueue = (indexOf + 1);
        int estimatedTimeToQueue =  positionInQueue * queueItemProcessTime;

        return new TimeToQueue(customerNumber, estimatedTimeToQueue, positionInQueue);
    }

    @PostMapping("/customer")
    public QueueItem addToQueue() {
        String last = customerQueue.last();
        if (last == null) {
            customerQueue.put(defaultFirstCustomNumber);

            return new QueueItem(defaultFirstCustomNumber);
        }

        String nextCustomerNumber = "A" + (Integer.parseInt(last.substring(1))+1);
        customerQueue.put(nextCustomerNumber);

        return new QueueItem(nextCustomerNumber);
    }
}
