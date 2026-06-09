package dev.popov.task.service;

import dev.popov.task.entity.IntArray;
import dev.popov.task.service.impl.SumServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SumServiceTest {

    static Stream<Arguments> sumDataProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, Optional.of(6)),
                arguments(new int[]{-1, 1}, Optional.of(0)),
                arguments(new int[]{10, 20, 30}, Optional.of(60))
        );
    }

    @ParameterizedTest
    @MethodSource("sumDataProvider")
    void calculateSumTest(int[] input, Optional<Integer> expected) {
        IntArray entity = new IntArray(input);

        SumService service = new SumServiceImpl();

        Optional<Integer> actual = service.calculateSum(entity);

        assertEquals(expected, actual);
    }

    @Test
    void calculateSumEmptyTest() {
        IntArray entity = new IntArray(new int[]{});

        SumService service = new SumServiceImpl();

        Optional<Integer> actual = service.calculateSum(entity);

        assertEquals(Optional.empty(), actual);
    }
}
