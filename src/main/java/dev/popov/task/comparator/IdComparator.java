package dev.popov.task.comparator;

import dev.popov.task.entity.IntArray;
import java.util.Comparator;

public class IdComparator implements Comparator<IntArray> {
    @Override
    public int compare(IntArray o1, IntArray o2) {
        return Long.compare(o1.getId(), o2.getId());
    }
}