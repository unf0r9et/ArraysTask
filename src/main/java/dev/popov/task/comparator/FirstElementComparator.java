package dev.popov.task.comparator;

import dev.popov.task.entity.IntArray;
import java.util.Comparator;

public class FirstElementComparator implements Comparator<IntArray> {
    @Override
    public int compare(IntArray o1, IntArray o2) {
        int[] arr1 = o1.getArray();
        int[] arr2 = o2.getArray();

        if (arr1.length == 0 || arr2.length == 0) {
            return Integer.compare(arr1.length, arr2.length);
        }

        return Integer.compare(arr1[0], arr2[0]);
    }
}