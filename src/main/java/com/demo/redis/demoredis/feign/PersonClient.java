package com.demo.redis.demoredis.feign;

import com.demo.redis.demoredis.entity.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "${feign.person-gateway.name}",
        url = "${feign.person-gateway.url}")
public interface PersonClient {

    @GetMapping("/person")
    Person find();
}
