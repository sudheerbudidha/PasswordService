package com.user.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.user.entity.User;

public interface UserRepository extends MongoRepository<User, String>, QueryDslPredicateExecutor<User> {
	
}
