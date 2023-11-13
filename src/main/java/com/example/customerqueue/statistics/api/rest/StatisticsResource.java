package com.example.customerqueue.statistics.api.rest;
import com.example.customerqueue.news.api.UserInfo;
import com.example.customerqueue.news.api.UserInfoRepository;
import com.example.customerqueue.statistics.api.Statistics;
import com.example.customerqueue.statistics.api.StatisticsRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class StatisticsResource {
    private final RestTemplate restTemplate;

    private final UserInfoRepository userInfoRepository;

    private final StatisticsRepository statisticsRepository;

    public StatisticsResource(RestTemplate restTemplate, UserInfoRepository userInfoRepository, StatisticsRepository statisticsRepository) {
        this.restTemplate = restTemplate;
        this.userInfoRepository = userInfoRepository;
        this.statisticsRepository = statisticsRepository;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/stats")
    public Iterable<Statistics> getStatistics() {
        Iterable<UserInfo> userInfos = userInfoRepository.findAll();

        Map<String, Long> countryVisitCountMap = StreamSupport.stream(userInfos.spliterator(), false)
                .collect(Collectors.groupingBy(UserInfo::getCountry, Collectors.counting()));

        return countryVisitCountMap.entrySet().stream()
                .map(entry -> new Statistics(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
    @CrossOrigin
    @GetMapping("/users")
    public Iterable<UserInfo> getUsers(){
        Iterable<UserInfo> userInfos = userInfoRepository.findAll();
        return  userInfos;
    }
}
