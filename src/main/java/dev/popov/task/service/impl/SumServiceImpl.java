package org.example.service.impl;

import org.example.entity.IntArray;
import org.example.service.SumService;

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
