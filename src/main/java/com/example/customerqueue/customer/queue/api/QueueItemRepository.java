package com.example.customerqueue.customer.queue.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface QueueItemRepository extends CrudRepository<QueueItem, Long> {

}
