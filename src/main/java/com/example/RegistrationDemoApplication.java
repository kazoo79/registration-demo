package com.example;

import com.example.registration.RegistrationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(RegistrationConfiguration.class)
public class RegistrationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationDemoApplication.class, args);
    }
}
