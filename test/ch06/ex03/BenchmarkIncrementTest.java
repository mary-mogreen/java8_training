package ch06.ex03;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class BenchmarkIncrementTest {
    private static final long expected = 1000 * 100000;
    @Test
    public void incrementAtomicLong() throws Exception {
        assertEquals(expected, BenchmarkIncrement.incrementAtomicLong());
    }

    @Test
    public void incrementLongAdder() throws Exception {
        assertEquals(expected, BenchmarkIncrement.incrementLongAdder());
    }

}