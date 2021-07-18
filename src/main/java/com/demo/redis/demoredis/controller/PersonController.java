package com.demo.redis.demoredis.controller;

import com.demo.redis.demoredis.entity.Person;
import com.demo.redis.demoredis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{account}")
    public ResponseEntity<Person> getPerson(@PathVariable("account") Long account,
                                                 @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                                 @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
        return new ResponseEntity<>(personService.execute(account, page, size), HttpStatus.OK);
    }
}
