package com.mccormack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class PrimeRangesAPI {
    public static void main(String[] args) {
        SpringApplication.run(PrimeRangesAPI.class);
    }
}
