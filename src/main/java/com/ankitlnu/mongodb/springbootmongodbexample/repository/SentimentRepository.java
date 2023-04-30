package com.ankitlnu.mongodb.springbootmongodbexample.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ankitlnu.mongodb.springbootmongodbexample.document.Sentiment;

@Repository
public interface SentimentRepository extends MongoRepository<Sentiment, String>  {

}
