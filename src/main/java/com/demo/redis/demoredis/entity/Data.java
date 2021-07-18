package com.demo.redis.demoredis.entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Data implements Serializable {
    private static final long serialVersionUID = -5748893102535097527L;

    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
}
