package com.demo.redis.demoredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableRedisRepositories
public class DemoRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRedisApplication.class, args);
    }

}
