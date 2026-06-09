package dev.popov.task.entity;

import dev.popov.task.observer.ArrayObserver;

import java.util.Arrays;

public class IntArray {

    private long id;
    private int[] array;
    private ArrayObserver observer;

    public IntArray() {
    }

    public IntArray(int[] array) {
        this.array = array.clone();
    }

    public IntArray(int id, int[] array, ArrayObserver observer) {
        this.id = id;
        this.array = array;
        this.observer = observer;
    }

    public int[] getArray() {
        return array.clone();
    }

    public long getId() {
        return id;
    }

    public void setElement(int index, int value) {
        if (index >= 0 && index < array.length) {
            array[index] = value;
            notifyObserver();
        }
    }

    public void setArray(int[] array) {
        this.array = array.clone();
    }

    public void notifyObserver() {
        if (observer != null) {
            observer.update(this);
        }
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
        StringBuilder sb = new StringBuilder();
        sb.append("IntArray{");
        sb.append("array=");
        sb.append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }
}
