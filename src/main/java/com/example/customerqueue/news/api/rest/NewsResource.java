package com.example.customerqueue.news.api.rest;

import com.example.customerqueue.news.api.NewsItem;
import com.example.customerqueue.news.api.NewsItemRepository;
import com.example.customerqueue.news.api.UserInfo;
import com.example.customerqueue.news.api.UserInfoRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class NewsResource {

    private final NewsItemRepository newsItemRepository;
    private final UserInfoRepository userInfoRepository;
    private static final Logger logger = LoggerFactory.getLogger(NewsResource.class);

    public NewsResource(NewsItemRepository newsItemRepository, UserInfoRepository userInfoRepository) {
        this.newsItemRepository = newsItemRepository;
        this.userInfoRepository = userInfoRepository;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/news")
    public Iterable<NewsItem> getNews() {
        Iterable<NewsItem> newsItems = newsItemRepository.findAll();

        return newsItems;
    }
    @CrossOrigin (origins = "*")
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

    @GetMapping("/get-user-info")
    public UserInfo getClientIp(HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        UserInfo info = new UserInfo(clientIp);
        logger.info(clientIp);
        return info;
    }
}
