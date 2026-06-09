package dev.popov.task.repository;

import dev.popov.task.entity.IntArray;
import dev.popov.task.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
    void add(IntArray entity);
    void remove(IntArray entity);
    List<IntArray> getAll();
    List<IntArray> query(ArraySpecification spec);
    List<IntArray> sort(Comparator<IntArray> comparator);
    int size();
    void clear();
}
