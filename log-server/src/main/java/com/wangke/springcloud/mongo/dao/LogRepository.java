package com.wangke.springcloud.mongo.dao;

import com.wangke.springcloud.mongo.model.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log,String> {
}
