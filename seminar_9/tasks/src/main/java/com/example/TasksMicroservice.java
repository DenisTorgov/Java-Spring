package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
public class TasksMicroservice {
    public static void main(String[] args) {
        SpringApplication.run(TasksMicroservice.class, args);
    }
}
