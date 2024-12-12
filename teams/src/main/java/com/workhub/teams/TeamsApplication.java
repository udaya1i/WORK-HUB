package com.workhub.teams;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.workhub")
public class TeamsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TeamsApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

        // TODO: initialise of default data

    }
}
