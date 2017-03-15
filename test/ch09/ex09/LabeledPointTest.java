package ch09.ex09;

import ch09.ex08.Point;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class LabeledPointTest {
    private LabeledPoint p1 = new LabeledPoint("p1", Integer.MAX_VALUE, Integer.MAX_VALUE);
    private LabeledPoint p2;

    @Test
    public void testEquals_true() {
        assertTrue(p1.equals(p1));

        p2 = new LabeledPoint("p1", Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(p1, p2);
    }

    @Test
    public void testEquals_false() {
        assertFalse(p1.equals(new Point(1, 1)));

        p2 = new LabeledPoint("p2", Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertNotEquals(p1, p2);
    }

    @Test
    public void testHashCode() {
        int p1HashCode = p1.hashCode();
        p2 = new LabeledPoint("p2", Integer.MAX_VALUE, Integer.MAX_VALUE);
        int p2HashCode = p2.hashCode();
        assertFalse(p1HashCode == p2HashCode);
    }

}