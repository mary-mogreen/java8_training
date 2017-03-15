package ch09.ex08;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class PointTest {
    private Point p1 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private Point p2;

    @Test
    public void testCompareTo1() {
        p2 = new Point(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertTrue(1 == p1.compareTo(p2));
    }

    @Test
    public void testCompareTo2() {
        p2 = new Point(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertTrue(-1 == p2.compareTo(p1));
    }

    @Test
    public void testCompareTo3() {
        p2 = new Point(Integer.MAX_VALUE, Integer.MIN_VALUE);
        assertTrue(1 == p1.compareTo(p2));
    }

    @Test
    public void testCompareTo4() {
        p2 = new Point(Integer.MAX_VALUE, Integer.MIN_VALUE);
        assertTrue(-1 == p2.compareTo(p1));
    }

    @Test
    public void testCompareTo5() {
        assertTrue(0 == p1.compareTo(p1));
    }

}