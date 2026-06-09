package dev.popov.task.warehouse.impl;

import dev.popov.task.entity.ArrayStatistics;
import dev.popov.task.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouseImpl implements ArrayWarehouse {
    private static final Logger logger = LogManager.getLogger();
    private final Map<Long, ArrayStatistics> storage = new HashMap<>();
    private static ArrayWarehouseImpl instance;

    public static ArrayWarehouseImpl getInstance() {
        if (instance == null) {
            instance = new ArrayWarehouseImpl();
            logger.info("Warehouse instance created");
        }
        return instance;
    }

    @Override
    public void put(long id, ArrayStatistics statistics) {
        storage.put(id, statistics);
        logger.info("Stored parameters for id={}: {}", id, statistics);
    }

    @Override
    public ArrayStatistics get(long id) {
        ArrayStatistics params = storage.get(id);

        if (params == null) {
            logger.warn("No parameters found for id={}", id);
        } else {
            logger.info("Retrieved parameters for id={}: {}", id, params);
        }

        return params;
    }

    @Override
    public void remove(long id) {
        storage.remove(id);
        logger.info("Removed parameters for id={}", id);
    }

    @Override
    public void clear() {
        storage.clear();
        logger.info("Warehouse is cleaned");
    }

}
