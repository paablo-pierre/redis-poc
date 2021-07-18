package com.demo.redis.demoredis.service.impl;

import com.demo.redis.demoredis.entity.Data;
import com.demo.redis.demoredis.entity.Person;
import com.demo.redis.demoredis.gateway.PersonGateway;
import com.demo.redis.demoredis.repository.PersonRepository;
import com.demo.redis.demoredis.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonGateway personGateway;
    private final PersonRepository personRepository;

    @Override
    @Cacheable(cacheNames = "PERSON_CACHE", key = "#page")
    public Person execute(Long account, int page, int size) {
        if(verifyIfHasCache(account)) {
            return searchPerson(account, page, size);
        }

        final var person = personGateway.find();

        person.setId(account);

        final var personToSave = personRepository.save(person);

        return personToSave;
    }

    private boolean verifyIfHasCache(Long id) {
        return personRepository.existsById(id);
    }

    private Person searchPerson(Long id, int page, int size) {
        var person = personRepository.findById(id);

        if(person.isPresent()) {
            final var pessoa = person.get();
            Pageable pageParam = PageRequest.of(page - 1, size);
            final var start = (int) pageParam.getOffset();
            final var end = (int) Math.min((start + pageParam.getPageSize()), pessoa.getData().size());

            Page<Data> dataPage = new PageImpl<>(pessoa.getData().subList(start, end), pageParam, pessoa.getData().size());

            return Person.builder()
                    .id(person.get().getId())
                    .data(dataPage.getContent())
                    .build();
        }

        return person.orElse(null);
    }
}
