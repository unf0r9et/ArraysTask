package dev.popov.task.specification.imlp;

import dev.popov.task.entity.IntArray;
import dev.popov.task.specification.ArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FindByIdSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger();

    private final int id;

    public FindByIdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(IntArray entity) {

        boolean result = entity.getId() == id;

        if (result) {
            logger.info("Entity matched by id={}", id);
        }

        return result;
    }
}
