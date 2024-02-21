package com.example.seminar_9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Seminar9ApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(Seminar9ApiGateway.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("TaskMicroservice",r->r.path("/serviceTasks/**")
						.uri("http://localhost:8081/")).build();
	}

}
