package com.mccormack.config;

import com.mccormack.model.PrimeCalculationMethod;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "primerangesapi")
@Getter
public class PrimeConfig {
    private PrimeCalculationMethod primeCalculationMethod;
}
