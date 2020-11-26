package com.wyk.webflux.service;

import com.wyk.webflux.document.Dog;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DogService {

	Flux<Dog> findAll();
	Mono<Dog> findById(String id);
	Mono<Dog> save(Dog dog);
	
}
