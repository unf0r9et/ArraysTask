package dev.popov.task.service;

import dev.popov.task.entity.IntArray;
import dev.popov.task.service.impl.MinMaxServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MinMaxServiceTest {
    static Stream<Arguments> minMaxDataProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, Optional.of(1), Optional.of(3)),
                arguments(new int[]{-10, 0, 10}, Optional.of(-10), Optional.of(10)),
                arguments(new int[]{5, 5, 5}, Optional.of(5), Optional.of(5))
        );
    }

    @ParameterizedTest
    @MethodSource("minMaxDataProvider")
    void findMinMaxTest(int[] input, Optional<Integer> expectedMin, Optional<Integer> expectedMax) {
        IntArray entity = new IntArray(input);
        MinMaxService service = new MinMaxServiceImpl();

        Optional<Integer> actualMin = service.findMin(entity);
        Optional<Integer> actualMax = service.findMax(entity);

        assertEquals(expectedMin, actualMin);
        assertEquals(expectedMax, actualMax);
    }

    @Test
    void findMinMaxEmptyTest() {
        IntArray entity = new IntArray(new int[]{});
        MinMaxService service = new MinMaxServiceImpl();

        Optional<Integer> actualMin = service.findMin(entity);

        assertEquals(Optional.empty(), actualMin);
    }
}
