package com.wyk.webflux.controller;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wyk.webflux.document.Dog;
import com.wyk.webflux.service.DogService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class DogController {

	@Autowired
	private DogService dogService;
	
	@GetMapping(value = "/dog")
	public Flux<Dog> getDogs(){
		return dogService.findAll();
	}
	
	@GetMapping(value = "/dog/{id}")
	public Mono<Dog> getDogs(@PathVariable String id){
		return dogService.findById(id);
	}
	
	@PostMapping(value = "/dog")
	public Mono<Dog> save(@RequestBody Dog dog) {
		return dogService.save(dog);
	}
	
	@GetMapping(value="/dog/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Dog>> getDogsStream() {
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(5));
		Flux<Dog> dogs = dogService.findAll();
		
		return Flux.zip(interval, dogs);
	}
}
