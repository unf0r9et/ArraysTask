package dev.popov.task.service.impl;

import dev.popov.task.entity.IntArray;
import dev.popov.task.service.SortService;

public class SortServiceImpl implements SortService {

    @Override
    public void bubbleSort(IntArray intArray) {
        int[] array = intArray.getArray();
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void selectionSort(IntArray intArray) {
        int[] array = intArray.getArray();
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
