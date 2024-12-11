package com.workhub.teams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.workhub")
public class TeamsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamsApplication.class, args);
    }

}
