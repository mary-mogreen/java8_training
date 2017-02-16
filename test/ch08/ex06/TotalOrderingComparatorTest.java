package ch08.ex06;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class TotalOrderingComparatorTest {
    @Test
    public void testPoint2DComparator() {
        Point2D p1 = new Point2D(-2.0, 3.0);
        Point2D p2 = new Point2D(3.0, 3.0);
        Point2D p3 = new Point2D(-2.0, 1.0);


        Comparator<Point2D> comparator = TotalOrderingComparator.point2DComparator;

        assertTrue(-1 == comparator.compare(p1, p2));
        assertTrue(0 == comparator.compare(p1, p1));
        assertTrue(1 == comparator.compare(p1, p3));
    }

    @Test
    public void testRectangle2DComparator() {
        Rectangle2D r1 = new Rectangle2D(-2.0, 3.0, 10.0, 10.0);
        Rectangle2D r2 = new Rectangle2D(-2.0, 3.0, 10.0, 1.0);
        Rectangle2D r3 = new Rectangle2D(-2.0, 3.0, 5.0, 10.0);
        Rectangle2D r4 = new Rectangle2D(-2.0, 2.0, 5.0, 10.0);
        Rectangle2D r5 = new Rectangle2D(2.0, 2.0, 5.0, 10.0);

        Comparator<Rectangle2D> comparator = TotalOrderingComparator.rectangle2DComparator;

        assertTrue(0 == comparator.compare(r1, r1));
        assertTrue(1 == comparator.compare(r1, r2));
        assertTrue(1 == comparator.compare(r2, r3));
        assertTrue(1 == comparator.compare(r3, r4));
        assertTrue(-1 == comparator.compare(r4, r5));
    }

}