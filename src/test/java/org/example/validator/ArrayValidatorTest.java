package org.example.validator;

import org.example.validator.impl.ArrayValidatorImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArrayValidatorTest {

    static Stream<Arguments> testDataProvider() {
        return Stream.of(
                arguments("1, 2, 3", true),
                arguments("hello world", false),
                arguments("12 wdada 12", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    void parseValidLinesTest(String input, boolean expected) {
        ArrayValidator validator = new ArrayValidatorImpl();

        boolean actual = validator.isValid(input);

        assertEquals(expected, actual);
    }

}
