package ch08.ex06;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;

/**
 * Created by mary-mogreen.
 */
public class TotalOrderingComparator {
    public static final Comparator<Point2D> point2DComparator = Comparator.comparing(Point2D::getX).thenComparing(Point2D::getY);

    public static final Comparator<Rectangle2D> rectangle2DComparator =
            Comparator.comparing(Rectangle2D::getMinX)
                    .thenComparing(Rectangle2D::getMinY)
                    .thenComparing(Rectangle2D::getWidth)
                    .thenComparing(Rectangle2D::getHeight);
}
