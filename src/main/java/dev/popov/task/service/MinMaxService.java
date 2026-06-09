package dev.popov.task.service;

import dev.popov.task.entity.IntArray;

import java.util.Optional;

public interface MinMaxService {
    Optional<Integer> findMin(IntArray entity);
    Optional<Integer> findMax(IntArray entity);
}
