package com.example.customerqueue.news.api;

import com.example.customerqueue.news.api.NewsItem;
import org.springframework.data.repository.CrudRepository;

public interface NewsItemRepository extends CrudRepository<NewsItem, Long> {

}
