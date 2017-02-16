package ch08.ex01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class UnsignedOperationTest {
    @Test
    public void testAdd() {
        int x = -1;
        int y = 0;

        assertTrue((x + y) == UnsignedOperation.add(x, y));
        assertTrue((x + x) == UnsignedOperation.add(x, x));

    }

    @Test
    public void testSub() {
        int x = -1;
        int y = 0;

        assertTrue((x - y) == UnsignedOperation.sub(x, y));
        assertTrue((x - x) == UnsignedOperation.sub(x, x));

    }

    @Test
    public void testDiv() {
        int x = -1;
        int y = 2;

        assertTrue(Integer.divideUnsigned(x, y) == UnsignedOperation.div(x, y));
        assertFalse((x / y) == UnsignedOperation.div(x, y));

        assertTrue(Integer.divideUnsigned(x, x) == UnsignedOperation.div(x, x));
        assertTrue((x / x) == UnsignedOperation.div(x, x));

    }

    @Test
    public void testCompare() {
        int x = -1;
        int y = 0;

        assertTrue(0 == UnsignedOperation.compare(x, x));

        assertTrue(1 == UnsignedOperation.compare(x, y));

        assertTrue(-1 == UnsignedOperation.compare(y, x));
    }

}