package com.example.customerqueue.customer.queue.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class QueueItem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty
    private Long id;

    @JsonProperty
    private String category;

    public QueueItem(String category) {
        this.category = category;
    }

    public QueueItem() {
    }
}
