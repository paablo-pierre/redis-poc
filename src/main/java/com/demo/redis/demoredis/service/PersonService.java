package com.demo.redis.demoredis.service;

import com.demo.redis.demoredis.entity.Person;

import java.util.List;

public interface PersonService {
    Person execute(Long account, int page, int size, String redisKey);
}
