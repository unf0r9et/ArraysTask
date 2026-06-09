package dev.popov.task.specification.imlp;
import dev.popov.task.entity.ArrayStatistics;
import dev.popov.task.entity.IntArray;
import dev.popov.task.specification.ArraySpecification;
import dev.popov.task.warehouse.impl.ArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaxInRangeSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger();

    private final int min;
    private final int max;
    private final ArrayWarehouseImpl warehouse;

    public MaxInRangeSpecification(int min, int max, ArrayWarehouseImpl warehouse) {
        this.min = min;
        this.max = max;
        this.warehouse = warehouse;
    }

    @Override
    public boolean specify(IntArray entity) {
        ArrayStatistics params = warehouse.get(entity.getId());

        if (params == null) {
            logger.warn("No parameters for entity id={}", entity.getId());
            return false;
        }

        double maxValue = params.getMax();
        boolean result = maxValue >= min && maxValue <= max;

        if (result) {
            logger.info("Entity id={} max={} in range [{}, {}]", entity.getId(), maxValue, min, max);
        } else {
            logger.debug("Entity id={} max={} NOT in range [{}, {}]", entity.getId(), maxValue, min, max);
        }

        return result;
    }
}
