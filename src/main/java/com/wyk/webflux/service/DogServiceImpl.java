package com.wyk.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyk.webflux.document.Dog;
import com.wyk.webflux.repository.DogRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DogServiceImpl implements DogService {

	@Autowired
	private DogRepository dogRepository;
	
	@Override
	public Flux<Dog> findAll() {
		return dogRepository.findAll();
	}

	@Override
	public Mono<Dog> findById(String id) {
		return dogRepository.findById(id);
	}

	@Override
	public Mono<Dog> save(Dog dog) {
		return dogRepository.save(dog);
	}

}
