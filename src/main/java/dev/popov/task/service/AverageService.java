package org.example.service;

import org.example.entity.IntArray;

import java.util.Optional;

public interface AverageService {
    Optional<Double> calculateAverage(IntArray entity);
}
