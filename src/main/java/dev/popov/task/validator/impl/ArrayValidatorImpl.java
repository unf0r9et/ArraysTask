package org.example.validator.impl;

import org.example.validator.ArrayValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final String REGEX = "^(\\s*-?\\d+\\s*[,-]?)*\\s*$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    @Override
    public boolean isValid(String line) {
        if (line == null) {
            return false;
        }

        Matcher matcher = PATTERN.matcher(line);
        return matcher.matches();
    }
}
