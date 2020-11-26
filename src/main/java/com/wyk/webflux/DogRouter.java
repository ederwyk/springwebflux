package com.wyk.webflux;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

//@Configuration
public class DogRouter {

//	@Bean
	public RouterFunction<ServerResponse> route(DogHandler handler) {
		return RouterFunctions
				.route(GET("/dog").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
				.andRoute(GET("/dog/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/dog").and(accept(MediaType.APPLICATION_JSON)), handler::save);
	}
	
}
