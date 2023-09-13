package com.example.customerqueue.news.api.rest;

import com.example.customerqueue.news.api.NewsItem;
import com.example.customerqueue.news.api.NewsItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class NewsResource {

    private final NewsItemRepository newsItemRepository;


    public NewsResource(NewsItemRepository newsItemRepository) {
        this.newsItemRepository = newsItemRepository;
    }
    @CrossOrigin(origins = "https://customer-queue-1s1w.onrender.com/")
    @GetMapping("/news")
    public Iterable<NewsItem> getNews() {
        Iterable<NewsItem> newsItems = newsItemRepository.findAll();

        return newsItems;
    }
    @CrossOrigin (origins = "https://customer-queue-1s1w.onrender.com/")
    @GetMapping("/article")
    @ResponseBody
    public Optional<NewsItem> getNewsItem(@RequestParam Long id) {
        return newsItemRepository.findById(id);
    }
    @PostMapping("/news")
    public NewsItem addNews(@RequestBody NewsItem newsItem) {
        String imagePath = newsItem.getImagePath();
        String date = newsItem.getDate();
        String title = newsItem.getTitle();
        String text = newsItem.getText();
        newsItemRepository.save(newsItem);
        return newsItem;
    }
}
