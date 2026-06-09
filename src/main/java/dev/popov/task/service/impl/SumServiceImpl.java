package dev.popov.task.service.impl;

import dev.popov.task.entity.IntArray;
import dev.popov.task.service.SumService;

import java.util.Optional;

public class SumServiceImpl implements SumService {

    @Override
    public Optional<Integer> calculateSum(IntArray entity) {
        int[] array = entity.getArray();

        if (array.length == 0) {
            return Optional.empty();
        }

        int sum = 0;
        for (int element : array) {
            sum += element;
        }

        return Optional.of(sum);
    }
}
