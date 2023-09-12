package com.example.customerqueue.news.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class NewsItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty
    private Long id;
    @JsonProperty
    String imagePath;
    @JsonProperty
    String text;

    @JsonProperty
    String title;

    @JsonProperty
    String date;

    public NewsItem(String imagePath,String text, String title, String date) {
        this.text = text;
        this.title = title;
        this.date = date;
        this.imagePath = imagePath;
    }
    public NewsItem(){

    }
    public String getTitle() {
        return this.title;
    }
    public String getImagePath() {
        return this.imagePath;
    }
    public String getDate() {
        return this.date;
    }
    public String getText() {
        return this.text;
    }
}
