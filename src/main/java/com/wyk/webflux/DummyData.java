package com.wyk.webflux;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wyk.webflux.document.Dog;
import com.wyk.webflux.repository.DogRepository;

import reactor.core.publisher.Flux;

//@Component
public class DummyData implements CommandLineRunner {

	private final DogRepository dogRepository;
	
	public DummyData(DogRepository dogRepository) {
		this.dogRepository = dogRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		dogRepository
			.deleteAll()
			.thenMany(
					Flux
						.just("Rex", "Laica", "Betoven")
						.map(name -> new Dog(UUID.randomUUID().toString(), name))
						.flatMap(dogRepository::save))
			.subscribe(System.out::println);
	}

}
