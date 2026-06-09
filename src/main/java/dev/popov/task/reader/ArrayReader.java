package dev.popov.task.reader;

import dev.popov.task.exception.ArrayReaderException;

import java.util.List;

public interface ArrayReader {
    List<String> readFile(String path) throws ArrayReaderException;
}
