package com.example.customerqueue.shows.api.rest;

import com.example.customerqueue.news.api.NewsItem;
import com.example.customerqueue.shows.api.ShowsItem;
import com.example.customerqueue.shows.api.ShowsItemRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class ShowsResource {
    private final ShowsItemRepository showsItemRepository;

    public ShowsResource(ShowsItemRepository showsItemRepository) {
        this.showsItemRepository = showsItemRepository;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/shows")
    @ResponseBody
    public Iterable<ShowsItem> getShows() {
        return showsItemRepository.findAll();
    }
    @CrossOrigin (origins = "*")
    @GetMapping("/show")
    @ResponseBody
    public Optional<ShowsItem> getNewsItem(@RequestParam Long id) {
        return showsItemRepository.findById(id);
    }
    @PostMapping("/shows")
    public ShowsItem addShow(@RequestBody ShowsItem showsItem) {
        Date date = showsItem.getShowDate();
        String location = showsItem.getLocation();
        String venueUrl = showsItem.getVenueURL();
        String venue = showsItem.getVenue();
        showsItemRepository.save(showsItem);
        return showsItem;
    }
}
