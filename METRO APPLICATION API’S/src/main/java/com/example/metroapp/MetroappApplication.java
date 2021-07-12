package com.example.metroapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class MetroappApplication {
    public static void main(String[] args) {
        SpringApplication.run(MetroappApplication.class, args);
    }
}
