package com.mccormack.service;

import com.mccormack.config.PrimeConfig;
import com.mccormack.model.PrimeCalculationMethod;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PrimeServiceTest {

    @Mock
    PrimeConfig mockPrimeConfig;

    @InjectMocks
    PrimeService primeService;

    @Test
    public void getPrimesListUpToValue_shouldReturnListOfPrimes_whenCalledWithPositiveInt_andGuavaIsSet() {
        when(mockPrimeConfig.getPrimeCalculationMethod()).thenReturn(PrimeCalculationMethod.GUAVA);
        List<Long> actual = primeService.getPrimesListUpToValue(10);
        assertThat(actual).containsExactly(2L, 3L, 5L, 7L);
    }

    @Test
    public void getPrimesListUpToValue_shouldReturnListOfPrimes_whenCalledWithPositiveInt_andBruteForceIsSet() {
        when(mockPrimeConfig.getPrimeCalculationMethod()).thenReturn(PrimeCalculationMethod.BRUTE_FORCE);
        List<Long> actual = primeService.getPrimesListUpToValue(10);
        assertThat(actual).containsExactly(2L, 3L, 5L, 7L);
    }

    @Test
    public void getPrimesListUpToValue_shouldThrowException_whenCalledWithInvalidInt() {
        assertThatThrownBy(() -> primeService.getPrimesListUpToValue(-1)).hasMessage("Negative numbers can't be prime");
    }
}
