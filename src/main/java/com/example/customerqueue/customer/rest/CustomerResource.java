package com.example.customerqueue.customer.rest;

import com.example.customerqueue.customer.api.CustomerDashboard;
import com.example.customerqueue.customer.queue.api.CustomerQueue;
import com.example.customerqueue.customer.rest.api.AddCustomerNumberRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
public class CustomerResource{

    private final CustomerQueue customerQueue;

    public CustomerResource(CustomerQueue customerQueue) {
        this.customerQueue = customerQueue;
    }

    @GetMapping("/")
    public CustomerDashboard customerDashboard() {
        String firstInQueue = customerQueue.peek();
        List<String> other = customerQueue.other();

        return new CustomerDashboard(firstInQueue, other);
    }

    @PostMapping("/")
    public void addToQueue(@RequestBody AddCustomerNumberRequest addCustomerNumberRequest) {
        customerQueue.put(addCustomerNumberRequest.getCustomerNumber());
    }
}
