package com.example.traveltothefuturebe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TravelToTheFutureBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelToTheFutureBeApplication.class, args);
    }

}
