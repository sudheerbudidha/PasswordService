package com.pwd.service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pwd.entity.Site;

@RepositoryRestResource(collectionResourceRel = "sites", path = "sites")
public interface SiteRepository extends MongoRepository<Site, String>, QueryDslPredicateExecutor<Site> {
	
}
