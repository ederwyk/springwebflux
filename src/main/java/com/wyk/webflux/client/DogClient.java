package com.wyk.webflux.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.wyk.webflux.document.Dog;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DogClient {

	@Value("${client.dog.url}")
	private String url;
	
	private WebClient client = WebClient.create(url);
	
	public Mono<Dog> getDog(String id) {
		return client
				.get()
				.uri("/dog/{id}", id)
				.retrieve()
				.bodyToMono(Dog.class)
				.log("Dog fetched ");
	}
	
	public Flux<Dog> getAllDogs() {
		return client
				.get()
				.uri("/dog")
				.retrieve()
				.bodyToFlux(Dog.class)
				.log("Dogs fetched ");
	}
	
	public Mono<Dog> createDog(Dog dog) {
		Mono<Dog> toSave = Mono.just(dog);
		
		return client
				.post()
				.uri("/dog")
				.contentType(MediaType.APPLICATION_JSON)
				.body(toSave, Dog.class)
				.retrieve()
				.bodyToMono(Dog.class)
				.log("Created dog ");
	}
	
}
