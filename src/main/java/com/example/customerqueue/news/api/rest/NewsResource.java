package com.example.customerqueue.news.api.rest;

import com.example.customerqueue.news.api.NewsItem;
import com.example.customerqueue.news.api.NewsItemRepository;
import com.example.customerqueue.news.api.UserInfo;
import com.example.customerqueue.news.api.UserInfoRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class NewsResource {

    private final RestTemplate restTemplate;
    private final NewsItemRepository newsItemRepository;
    private final UserInfoRepository userInfoRepository;

    private static final Logger logger = LoggerFactory.getLogger(NewsResource.class);
    public NewsResource(NewsItemRepository newsItemRepository, UserInfoRepository userInfoRepository, RestTemplate restTemplate) {
        this.newsItemRepository = newsItemRepository;
        this.userInfoRepository = userInfoRepository;
        this.restTemplate = restTemplate;
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
    @CrossOrigin (origins = "*")
    @GetMapping("/get-user-info")
    public UserInfo getClientIp(HttpServletRequest request) {
        String clientIp = request.getHeader("X-Forwarded-For");

        //logger.info(clientIp);
        String apiUrl = "http://ip-api.com/json/" + clientIp;

        UserInfo info = restTemplate.getForObject(apiUrl, UserInfo.class);
        UserInfo user = new UserInfo();

        if(info != null) {
            user.setId(clientIp);
            //info.setQuery(clientIp);
            user.setCity(info.getCity());
            user.setQuery(info.getQuery());
            user.setCountry(info.getCountry());
            user.setStatus(info.getStatus());
            userInfoRepository.save(user);
            //System.out.println(user.getQuery());
            System.out.println(clientIp);
        }
        return info;
    }
}
