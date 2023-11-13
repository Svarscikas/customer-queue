package com.example.customerqueue.statistics.api;
import org.springframework.data.repository.CrudRepository;
import com.example.customerqueue.statistics.api.Statistics;
public interface StatisticsRepository extends CrudRepository <Statistics, Long> {
}
