package com.example.customerqueue.news.api;

import com.example.customerqueue.news.api.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {

}
