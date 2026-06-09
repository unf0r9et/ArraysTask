package org.example.service;

import org.example.entity.IntArray;

import java.util.Optional;

public interface SumService {
    Optional<Integer> calculateSum(IntArray entity);
}
