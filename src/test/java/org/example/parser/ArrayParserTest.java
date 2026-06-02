package org.example.parser;

import org.example.parser.impl.ArrayParserImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArrayParserTest {

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                arguments("1, 2, 3", new int[]{1, 2, 3}),
                arguments("10 20 30", new int[]{10, 20, 30}),
                arguments("5 - -6 - 7", new int[]{5, -6, 7})
        );
    }

    private static final String EMPTY_LINE = "  ";
    private static final int[] EMPTY_EXPECTED_ARRAY = {};

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void parseValidLinesTest(String input, int[] expected) {
        ArrayParser parser = new ArrayParserImpl();

        int[] actual = parser.parse(input);

        assertArrayEquals(expected, actual);
    }

    @Test
    void parseEmptyLineTest() {
        ArrayParser parser = new ArrayParserImpl();

        int[] actualArray = parser.parse(EMPTY_LINE);

        assertArrayEquals(EMPTY_EXPECTED_ARRAY, actualArray);
    }
}
