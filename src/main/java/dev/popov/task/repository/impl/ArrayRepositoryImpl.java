package dev.popov.task.repository.impl;

import dev.popov.task.entity.IntArray;
import dev.popov.task.repository.ArrayRepository;
import dev.popov.task.specification.ArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static final Logger logger = LogManager.getLogger();

    private static ArrayRepositoryImpl instance;
    final private List<IntArray> storage = new ArrayList<>();

    public static ArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ArrayRepositoryImpl();
            logger.info("Repository instance created");
        }
        return instance;
    }

    @Override
    public void add(IntArray entity) {
        storage.add(entity);
        logger.info("Added entity id={}", entity.getId());
    }

    @Override
    public void remove(IntArray entity) {
        storage.remove(entity);
        logger.info("Removed entity id={}", entity.getId());
    }

    @Override
    public List<IntArray> getAll() {
        logger.info("Retrieving all entities");
        return new ArrayList<>(storage);
    }

    @Override
    public List<IntArray> query(ArraySpecification spec) {
        List<IntArray> result = new ArrayList<>();

        for (IntArray element : storage) {
            if (spec.specify(element)) {
                result.add(element);
            }
        }

        logger.info("Query executed, found {} entities", result.size());
        return result;
    }

    @Override
    public List<IntArray> sort(Comparator<IntArray> comparator) {
        List<IntArray> sortedList = new ArrayList<>(storage);
        sortedList.sort(comparator);
        return sortedList;
    }

    @Override
    public int size() {
        logger.info("Repository size requested: {}", storage.size());
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
        logger.info("Repository cleared");
    }
}
