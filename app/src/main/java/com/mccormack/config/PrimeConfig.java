package com.mccormack.config;

import com.mccormack.model.PrimeCalculationMethod;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "primerangesapi")
@Getter
@Setter
public class PrimeConfig {
    private PrimeCalculationMethod primeCalculationMethod;
}
