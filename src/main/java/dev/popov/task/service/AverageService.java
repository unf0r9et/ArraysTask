package dev.popov.task.service;

import dev.popov.task.entity.IntArray;

import java.util.Optional;

public interface AverageService {
    Optional<Double> calculateAverage(IntArray entity);
}
