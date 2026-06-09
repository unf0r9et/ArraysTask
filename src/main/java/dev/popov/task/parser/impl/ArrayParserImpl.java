package dev.popov.task.parser.impl;

import dev.popov.task.parser.ArrayParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayParserImpl implements ArrayParser {
    private static final String REGEX = "-?\\d+";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    @Override
    public int[] parse(String line) {

        if (line.isBlank()) {
            return new int[0];
        }

        Matcher matcher = PATTERN.matcher(line);

        List<Integer> tempStorage = new ArrayList<>();

        while (matcher.find()) {
            String numberMatch = matcher.group();
            int value = Integer.parseInt(numberMatch);

            tempStorage.add(value);
        }

        int size = tempStorage.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = tempStorage.get(i);
        }

        return result;
    }
}
