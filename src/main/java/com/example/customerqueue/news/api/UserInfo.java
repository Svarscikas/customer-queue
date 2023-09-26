package com.example.customerqueue.news.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty
    private Long id;

    @JsonProperty
    String ipAddress;
    public UserInfo() {
    }

    public UserInfo(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
