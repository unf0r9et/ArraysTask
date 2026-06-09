package dev.popov.task.service.impl;

import dev.popov.task.entity.IntArray;
import dev.popov.task.service.AverageService;

import java.util.Optional;

public class AverageServiceImpl implements AverageService {

    @Override
    public Optional<Double> calculateAverage(IntArray entity) {
        int[] array = entity.getArray();
        int length = array.length;

        if (length == 0) {
            return Optional.empty();
        }

        long sum = 0;
        for (int number : array) {
            sum = sum + number;
        }

        double average = (double) sum / length;

        return Optional.of(average);
    }
}
