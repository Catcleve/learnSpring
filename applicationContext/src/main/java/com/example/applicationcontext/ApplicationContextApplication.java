package com.example.applicationcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationContextApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ApplicationContextApplication.class, args);
    }

}
