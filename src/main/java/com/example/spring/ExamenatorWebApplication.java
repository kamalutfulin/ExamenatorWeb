package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ExamenatorWebApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(ExamenatorWebApplication.class, args);
    }

}
