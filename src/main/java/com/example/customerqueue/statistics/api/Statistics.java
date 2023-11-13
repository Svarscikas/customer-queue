package com.example.customerqueue.statistics.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Statistics {
    @Id
    private long id;
    @JsonProperty
    String country;
    @JsonProperty
    long visitCount;

    public Statistics(String country, long visitCount) {
        this.country = country;
        this.visitCount = visitCount;
    }

    public long getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
