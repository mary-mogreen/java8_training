package ch06.ex04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class LongAccumulatorUsageTest {
    private static long max = 3246463;
    private static long min = -645342;
    private static long[] testData = {-145, 4532, 35, 607, max, 64024, min, 0, 539509, 4256, 53489, 2};
    private static List<Long> testDataList = new ArrayList<>();
    {
        for (long data: testData)
            testDataList.add(data);
    }

    @Test
    public void testMax() {
        assertEquals(max, LongAccumulatorUsage.max(testDataList));
    }

    @Test(expected = NullPointerException.class)
    public void testMax_null() {
        assertEquals(max, LongAccumulatorUsage.max(null));
    }

    @Test
    public void testMax_empty() {
        assertEquals(Long.MIN_VALUE, LongAccumulatorUsage.max(new ArrayList<>()));
    }

    @Test
    public void testMin() {
        assertEquals(min, LongAccumulatorUsage.min(testDataList));
    }

    @Test(expected = NullPointerException.class)
    public void testMin_null() {
        assertEquals(min, LongAccumulatorUsage.min(null));
    }

    @Test
    public void testMin_empty() {
        assertEquals(Long.MAX_VALUE, LongAccumulatorUsage.min(new ArrayList<>()));
    }

}