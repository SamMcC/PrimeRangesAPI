package com.mccormack.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Jacksonized
@Builder
@Getter
public class PrimeResponse {
    @JsonProperty("Initial")
    private long initial;
    @JsonProperty("Primes")
    private List<Long> primes;
}
