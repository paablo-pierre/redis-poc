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

    List<Data> data;

    /*private Long id;
    private String firstName;
    private String lastName;
    private String gender;*/
}
