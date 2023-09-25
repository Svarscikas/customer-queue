package com.example.customerqueue.shows.api;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class ShowsItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty
    private Long id;
    @JsonProperty
    Date showDate;

    @JsonProperty
    String location;

    @JsonProperty
    String venueURL;

    @JsonProperty
    String venue;

    public ShowsItem() {
    }

    public ShowsItem(Date showDate, String location, String venueURL, String venue) {
        this.showDate = showDate;
        this.location = location;
        this.venueURL = venueURL;
        this.venue = venue;
    }

    public Date getShowDate() {
        return showDate;
    }

    public String getVenueURL() {
        return venueURL;
    }

    public String getLocation() {
        return location;
    }

    public String getVenue() {
        return venue;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
