package com.example.customerqueue.news.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;

@Entity
public class UserInfo {
    @JsonProperty
    private Long id;

    @JsonProperty
    String ipAddress;
    public UserInfo(Long id) {
        this.id = id;
    }

    public UserInfo(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
