package ch06.ex04;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * Created by mary-mogreen.
 */
public class LongAccumulatorUsage {
    public static long max(List<Long> longs) {
        Objects.requireNonNull(longs, "long value list is null.");
        
        if (longs.isEmpty())
            throw new IllegalArgumentExceotion("list is empty.");
        
        LongAccumulator max = new LongAccumulator((l1, l2) -> {
            return l1 > l2 ? l1: l2;
        }, Long.MIN_VALUE);
        longs.parallelStream().forEach(l -> max.accumulate(l));
        return max.get();
    }

    public static long min(List<Long> longs) {
        Objects.requireNonNull(longs, "long value list is null.");
        
        if (longs.isEmpty())
            throw new IllegalArgumentExceotion("list is empty.");
        
        LongAccumulator min = new LongAccumulator((l1, l2) -> {
            return l1 > l2 ? l2: l1;
        }, Long.MAX_VALUE);
        longs.parallelStream().forEach(l -> min.accumulate(l));
        return min.get();
    }
}
