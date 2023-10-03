package com.example.customerqueue.news.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class UserInfo {
    @Id
    String id;
    @JsonProperty
    String query;
    @JsonProperty
    String country;
    @JsonProperty
    String status;

    public UserInfo() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuery() {
        return query;
    }

    public UserInfo(String status, String country) {
        this.status = status;
        this.country = country;
    }
}
