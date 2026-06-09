package dev.popov.task;

import dev.popov.task.exception.ArrayReaderException;
import dev.popov.task.parser.ArrayParser;
import dev.popov.task.parser.impl.ArrayParserImpl;
import dev.popov.task.reader.ArrayReader;
import dev.popov.task.reader.impl.ArrayReaderImpl;
import dev.popov.task.validator.ArrayValidator;
import dev.popov.task.validator.impl.ArrayValidatorImpl;
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

        String path = "files/arrays.txt";

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