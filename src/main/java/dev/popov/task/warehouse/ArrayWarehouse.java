package dev.popov.task.warehouse;

import dev.popov.task.entity.ArrayStatistics;

public interface ArrayWarehouse {
    void put(long id, ArrayStatistics statistics);
    ArrayStatistics get(long id);
    void remove(long id);
    void clear();
}
