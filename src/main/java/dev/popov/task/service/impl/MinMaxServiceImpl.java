package dev.popov.task.service.impl;

import dev.popov.task.entity.IntArray;
import dev.popov.task.service.MinMaxService;

import java.util.Optional;

public class MinMaxServiceImpl implements MinMaxService {

    @Override
    public Optional<Integer> findMin(IntArray entity) {
        int[] array = entity.getArray();

        if (array.length == 0) {
            return Optional.empty();
        }

        int minValue = array[0];
        for (int element : array) {
            if (element < minValue) {
                minValue = element;
            }
        }

        return Optional.of(minValue);
    }

    @Override
    public Optional<Integer> findMax(IntArray entity) {
        int[] array = entity.getArray();

        if (array.length == 0) {
            return Optional.empty();
        }

        int maxValue = array[0];
        for (int element : array) {
            if (element > maxValue) {
                maxValue = element;
            }
        }

        return Optional.of(maxValue);
    }
}
