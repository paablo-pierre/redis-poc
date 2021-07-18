package com.demo.redis.demoredis.gateway.impl;

import com.demo.redis.demoredis.entity.Person;
import com.demo.redis.demoredis.feign.PersonClient;
import com.demo.redis.demoredis.gateway.PersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonGatewayImpl implements PersonGateway {
    private final PersonClient personClient;

    @Override
    public Person find() {
        return personClient.find();
    }
}
