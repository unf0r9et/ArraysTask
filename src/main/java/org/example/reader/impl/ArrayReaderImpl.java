package org.example.reader.impl;

import org.example.exception.ArrayReaderException;
import org.example.reader.ArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {
    private static final Logger logger = LogManager.getLogger(ArrayReaderImpl.class);

    @Override
    public List<String> readFile(String path) throws ArrayReaderException {
        try {
            Path filePath = Path.of(path);
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            logger.error("Error while reading file: {}", path, e);
            throw new ArrayReaderException("Could not read file at path: " + path, e);
        }
    }
}
