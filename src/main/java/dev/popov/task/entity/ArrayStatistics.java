package dev.popov.task.entity;

public class ArrayStatistics {
    private int min;
    private int max;
    private int sum;
    private double average;

    public ArrayStatistics(int min, int max, int sum, double average) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }

    public int getSum() {
        return sum;
    }

    public int getMax() {
        return max;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
