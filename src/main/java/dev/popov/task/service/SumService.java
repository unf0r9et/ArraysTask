package dev.popov.task.service;

import dev.popov.task.entity.IntArray;

import java.util.Optional;

public interface SumService {
    Optional<Integer> calculateSum(IntArray entity);
}
