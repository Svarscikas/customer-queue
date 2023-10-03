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
    String query;
    @JsonProperty
    String country;
    @JsonProperty
    String status;
    public UserInfo() {
    }

    public UserInfo(String query,String status, String country) {
        this.query = query;
        this.status = status;
        this.country = country;
    }
}
