package com.demo.redis.demoredis.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("Person")
public class Person implements Serializable {
    private static final long serialVersionUID = -1111119978344701447L;

    @Id
    private Long id;

    private List<Data> data;

    private int total;

    public static String generateRedisKey(Long account, int page, int size) {
        return String.valueOf(account).concat("-").concat(String.valueOf(page)).concat("-").concat(String.valueOf(size));
    }
}
