package com.ankitlnu.mongodb.springbootmongodbexample.config;

import com.ankitlnu.mongodb.springbootmongodbexample.document.Users;
import com.ankitlnu.mongodb.springbootmongodbexample.repository.SentimentRepository;
import com.ankitlnu.mongodb.springbootmongodbexample.repository.UserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = {UserRepository.class, SentimentRepository.class})
@Configuration
public class MongoDBConfig {


    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return strings -> {
            userRepository.save(new Users(1, "Peter", "Development", 3000L));
            userRepository.save(new Users(2, "Sam", "Operations", 2000L));
        };
    }

}
