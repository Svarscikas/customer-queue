package com.example.customerqueue.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class inactivityPrevention {
    @Scheduled(fixedRate = 600000) // 10 minutes in milliseconds
    public void preventInactivity() {
        // Perform a lightweight operation (e.g., log a message)
        // This will keep the server alive and prevent it from idling
        System.out.println("Server activity simulated.");
    }
}
