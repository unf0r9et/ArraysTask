package dev.popov.task.observer.impl;

import dev.popov.task.entity.ArrayStatistics;
import dev.popov.task.entity.IntArray;
import dev.popov.task.observer.ArrayObserver;
import dev.popov.task.warehouse.ArrayWarehouse;

public class ArrayObserverImpl implements ArrayObserver {

    private final ArrayWarehouse warehouse;

    public ArrayObserverImpl(ArrayWarehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void update(IntArray entity) {
        ArrayStatistics statistic = calculate(entity.getArray());
        warehouse.put(entity.getId(), statistic);
    }

    private ArrayStatistics calculate(int[] array){
        int sum = 0;
        int min = array[0];
        int max = array[0];

        for (int element : array) {
            sum += element;
            if (element < min) min = element;
            if (element > max) max = element;
        }

        double average = (double) sum / array.length;

        return new ArrayStatistics(min, max, sum, average);
    }
}
