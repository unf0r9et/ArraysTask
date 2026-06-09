package org.example.entity;

import java.util.Arrays;

public class IntArray {
    private int[] array;

    public IntArray() {}
    public IntArray(int[] array) {
        this.array = array.clone();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        IntArray intArray = (IntArray) o;
        return Arrays.equals(array, intArray.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "IntArray{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
