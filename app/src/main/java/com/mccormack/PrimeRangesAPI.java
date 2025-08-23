package com.mccormack;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mccormack")
@Slf4j
public class PrimeRangesAPI {
    public static void main(String[] args) {
        SpringApplication.run(PrimeRangesAPI.class, args);
    }
}
