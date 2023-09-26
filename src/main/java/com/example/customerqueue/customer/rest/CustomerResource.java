package com.example.customerqueue.customer.rest;

import com.example.customerqueue.customer.api.CustomerDashboard;
import com.example.customerqueue.customer.queue.api.QueueItem;
import com.example.customerqueue.customer.queue.api.QueueItemRepository;
import com.example.customerqueue.customer.rest.api.QueueItemModel;
import com.example.customerqueue.customer.rest.api.TimeToQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CustomerResource {

    //@Value("${queue-item-process-time}")
    //private int queueItemProcessTime;

    //@Value("${default-first-customer-number}")
    //private String defaultFirstCustomNumber;

    private final QueueItemRepository queueItemRepository;

    public CustomerResource(QueueItemRepository queueItemRepository) {
        this.queueItemRepository = queueItemRepository;
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/customer")
    public Iterable<QueueItem> customerDashboard() {
        Iterable<QueueItem> queueItems = queueItemRepository.findAll();

        return queueItems;
    }

    @GetMapping("/customer/{customerNumber}")
    public TimeToQueue timeToVisit(@PathVariable("customerNumber") String customerNumber) {
        return null;
    }

    @PostMapping("/customer")
    public QueueItem addToQueue() {
        QueueItem queueItem = new QueueItem("A");

        queueItemRepository.save(queueItem);

        return queueItem;
    }
}
