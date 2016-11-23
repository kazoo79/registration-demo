package com.example.registration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.logging.Logger;

/**
 * Created by pdebala on 2016-10-06.
 */
@Configuration
@ComponentScan
@EntityScan //("io.pivotal.microservices.accounts")
//@EnableJpaRepositories("io.pivotal.microservices.accounts")
//@PropertySource("classpath:db-config.properties")
public class RegistrationConfiguration {

    protected Logger logger;

    public RegistrationConfiguration() {
        logger = Logger.getLogger(getClass().getName());
    }

    @Bean
    public CommandLineRunner initializeDb(UserRepository repository){
        logger.info("Initializing database...");
        return (args) -> {
            // save a couple of users
            repository.save(new User("aaaa", "aaaa@sample.pl", "6576575765"));
            repository.save(new User("bbb", "bbb@sample.pl", "jgsdhf"));
            repository.save(new User("ccc", "ccc@sample.pl", "ahgdjhdh"));
            repository.save(new User("ddd", "ddd@sample.pl", "jsfdjgsj"));
            repository.save(new User("eee", "eee@sample.pl", "vvjhvjh"));
        };
    }
}
