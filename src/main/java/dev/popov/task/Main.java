package org.example;

import org.example.exception.ArrayReaderException;
import org.example.parser.ArrayParser;
import org.example.parser.impl.ArrayParserImpl;
import org.example.reader.ArrayReader;
import org.example.reader.impl.ArrayReaderImpl;
import org.example.validator.ArrayValidator;
import org.example.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ArrayReaderException {
        ArrayReader reader = new ArrayReaderImpl();
        ArrayValidator validator = new ArrayValidatorImpl();
        ArrayParser parser = new ArrayParserImpl();

        String path = "src/main/resources/arrays.txt";

        List<String> lines = reader.readFile(path);

        for (String line : lines) {
            boolean isValid = validator.isValid(line);

            if (isValid) {
                int[] intArray = parser.parse(line);

                String arrayString = Arrays.toString(intArray);
                logger.info("Valid array found: " + arrayString);
            } else {
                logger.warn("Invalid line skipped: " + line);
            }
        }
    }
}