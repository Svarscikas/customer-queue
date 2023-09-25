package com.example.customerqueue.shows.api;

import com.example.customerqueue.shows.api.ShowsItem;
import org.springframework.data.repository.CrudRepository;

public interface ShowsItemRepository extends CrudRepository<ShowsItem, Long> {
}
