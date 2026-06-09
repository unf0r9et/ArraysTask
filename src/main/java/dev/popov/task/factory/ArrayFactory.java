package dev.popov.task.factory;

import dev.popov.task.entity.IntArray;

public class ArrayFactory {
    public IntArray createIntArray(int[] array) {
        return new IntArray(array);
    }
}
