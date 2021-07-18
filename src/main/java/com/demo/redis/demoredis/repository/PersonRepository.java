package com.demo.redis.demoredis.repository;

import com.demo.redis.demoredis.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Page<Person> findAll(Pageable pageable);
}
