package org.example.service;

import org.example.entity.IntArray;
import org.example.service.impl.AverageServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AverageServiceTest {

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, Optional.of(2.0)),
                arguments(new int[]{-1, -2, -3}, Optional.of(-2.0)),
                arguments(new int[]{1, 2}, Optional.of(1.5)),
                arguments(new int[]{10}, Optional.of(10.0))
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void calculateAverageTest(int[] input, Optional<Double> expected) {
        IntArray entity = new IntArray(input);

        AverageService service = new AverageServiceImpl();

        Optional<Double> actual = service.calculateAverage(entity);

        assertEquals(expected, actual);
    }

    @Test
    void calculateAverageNullTest() {
        IntArray entity = new IntArray(new int[]{});

        AverageService service = new AverageServiceImpl();

        Optional<Double> actual = service.calculateAverage(entity);

        assertEquals(Optional.empty(), actual);
    }
}
