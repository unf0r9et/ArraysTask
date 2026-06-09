package dev.popov.task.service;

import dev.popov.task.entity.IntArray;
import dev.popov.task.service.impl.SortServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SortServiceTest {

    static Stream<Arguments> sortDataProvider() {
        return Stream.of(
                arguments(new int[]{3, 1, 2}, new int[]{1, 2, 3}),
                arguments(new int[]{10, -1, 5}, new int[]{-1, 5, 10}),
                arguments(new int[]{1, 2, 3}, new int[]{1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("sortDataProvider")
    void bubbleSortTest(int[] input, int[] expected) {
        IntArray entity = new IntArray(input);
        IntArray expectedEntity = new IntArray(expected);
        SortService service = new SortServiceImpl();

        service.bubbleSort(entity);

        assertEquals(expectedEntity, entity);
    }

    @ParameterizedTest
    @MethodSource("sortDataProvider")
    void selectionSortTest(int[] input, int[] expected) {
        IntArray entity = new IntArray(input);

        IntArray expectedEntity = new IntArray(expected);

        SortService service = new SortServiceImpl();

        service.selectionSort(entity);

        assertEquals(expectedEntity, entity);
    }
}