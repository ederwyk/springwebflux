package com.wyk.webflux;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wyk.webflux.document.Dog;
import com.wyk.webflux.service.DogService;

import reactor.core.publisher.Mono;

//@Component
public class DogHandler {

	@Autowired
	private DogService dogService;
	
	public Mono<ServerResponse> findAll(ServerRequest request) {
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(dogService.findAll(), Dog.class);
	}
	
	public Mono<ServerResponse> findById(ServerRequest request) {
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(dogService.findById(id), Dog.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		final Mono<Dog> dog = request.bodyToMono(Dog.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(dog.flatMap(dogService::save), Dog.class));
	}
	
}
