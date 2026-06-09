package dev.popov.task.comparator;

import dev.popov.task.entity.IntArray;
import java.util.Comparator;

public class LengthComparator implements Comparator<IntArray> {
    @Override
    public int compare(IntArray o1, IntArray o2) {
        int length1 = o1.getArray().length;
        int length2 = o2.getArray().length;
        return Integer.compare(length1, length2);
    }
}