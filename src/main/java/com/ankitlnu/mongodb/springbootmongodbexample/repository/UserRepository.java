package com.ankitlnu.mongodb.springbootmongodbexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ankitlnu.mongodb.springbootmongodbexample.document.Users;

public interface UserRepository extends MongoRepository<Users, Integer> {
}
