package dev.popov.task.specification.imlp;

import dev.popov.task.entity.ArrayStatistics;
import dev.popov.task.entity.IntArray;
import dev.popov.task.specification.ArraySpecification;
import dev.popov.task.warehouse.impl.ArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumGreaterThanSpecification implements ArraySpecification {

    private static final Logger logger = LogManager.getLogger();

    private double threshold;
    private ArrayWarehouseImpl warehouse;

    public SumGreaterThanSpecification(double threshold, ArrayWarehouseImpl warehouse) {
        this.threshold = threshold;
        this.warehouse = warehouse;
    }

    @Override
    public boolean specify(IntArray entity) {
        ArrayStatistics params = warehouse.get(entity.getId());

        if (params == null) {
            logger.warn("No parameters for entity id={}", entity.getId());
            return false;
        }

        boolean result = params.getSum() > threshold;

        if (result) {
            logger.info("Entity id={} passed sum > {}", entity.getId(), threshold);
        }

        return result;
    }
}