package com.mccormack.service;

import com.google.common.math.LongMath;
import com.mccormack.config.PrimeConfig;
import com.mccormack.exception.NonCalculableInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.LongPredicate;
import java.util.stream.LongStream;

@Service
@RequiredArgsConstructor
public class PrimeService {
    private final PrimeConfig primeConfig;

    public List<Long> getPrimesListUpToValue(long value) {
        if (value < 1) {
            throw new NonCalculableInputException("Numbers less than 2 can't be prime");
        }
        return LongStream.range(1, value)
                .filter(getPrimeCalculationMethod())
                .boxed()
                .toList();
    }

    private LongPredicate getPrimeCalculationMethod() {
        return switch(primeConfig.getPrimeCalculationMethod()) {
            case GUAVA -> LongMath::isPrime;
            case BRUTE_FORCE -> this::bruteForce;
        };
    }

    private boolean bruteForce(long longValue) {
        if (longValue <= 1) {
            return false;
        }
        return LongStream
                .range(2L, (longValue / 2) + 1)
                .noneMatch(i -> longValue % i == 0);
    }


}
