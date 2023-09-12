package com.example.customerqueue.specialist.rest;

import jakarta.persistence.Entity;

public class Specialist {
    private long id;
    private String username;

    public Specialist(long id, String username) {
        this.id = id;
        this.username = username;
    }

}
