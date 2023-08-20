package com.example.customerqueue.customer.rest;


import com.example.customerqueue.customer.api.CustomerDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerResource{

    @GetMapping("/")
    public CustomerDashboard customerDashboard() {
        CustomerDashboard customerDashboard = new CustomerDashboard("A02", List.of("A003", "A004"));

        return customerDashboard;
    }
}
