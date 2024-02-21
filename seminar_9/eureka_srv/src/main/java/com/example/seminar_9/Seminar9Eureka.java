package com.example.seminar_9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class Seminar9Eureka {

	public static void main(String[] args) {
		SpringApplication.run(Seminar9Eureka.class, args);
	}

//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route("TaskMicroservice",r->r.path("/serviceTasks/**")
//						.uri("http://localhost:8081/")).build();
//	}

}
