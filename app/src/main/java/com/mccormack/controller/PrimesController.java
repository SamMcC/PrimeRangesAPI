package com.mccormack.controller;

import com.mccormack.model.PrimeResponse;
import com.mccormack.service.PrimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.mccormack.config.Endpoints.PRIMES_ENDPOINT;

@RestController(PRIMES_ENDPOINT)
@RequiredArgsConstructor
public class PrimesController {
    private PrimeService primeService;

    @GetMapping("{input}")
    public PrimeResponse getPrimes(@PathVariable Long input) {
        List<Long> primes = primeService.getPrimesListUpToValue(input);
        return PrimeResponse.builder()
                .initial(input)
                .primes(primes)
                .build();
    }
}
