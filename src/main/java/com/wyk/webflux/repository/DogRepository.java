package com.wyk.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.wyk.webflux.document.Dog;

public interface DogRepository extends ReactiveMongoRepository<Dog, String>{

}
