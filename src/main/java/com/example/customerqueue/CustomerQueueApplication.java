package com.example.customerqueue;

import com.example.customerqueue.tasks.inactivityPrevention;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableScheduling // Enable Spring's scheduling
@SpringBootApplication
public class CustomerQueueApplication {
	private static final Logger log = LoggerFactory.getLogger(CustomerQueueApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CustomerQueueApplication.class, args);
	}
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
