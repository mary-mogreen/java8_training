package ch06.ex02;

import java.util.concurrent.atomic.LongAdder;

/**
 * Created by mary-mogreen.
 */
public class IDManager {
    private static final LongAdder id = new LongAdder();

    public static long newId() {
        id.increment();
        return id.longValue(); // incrementとsumがアトミックでないので，LongAdderは役に立たない。
    }

    public static long newIdWithLock() {
        long newId;
        synchronized (id) {
            id.increment();
            newId = id.longValue();
        }
        return newId;
    }
}
