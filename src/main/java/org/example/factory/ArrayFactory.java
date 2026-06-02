package org.example.factory;

import org.example.entity.IntArray;

public class ArrayFactory {
    public IntArray createIntArray(int[] array) {
        return new IntArray(array);
    }
}
