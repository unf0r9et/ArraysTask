package org.example.service;

import org.example.entity.IntArray;

import java.util.Optional;

public interface MinMaxService {
    Optional<Integer> findMin(IntArray entity);
    Optional<Integer> findMax(IntArray entity);
}
