package ch09.ex08;

/**
 * Created by mary-mogreen.
 */
public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point other) {
        if (x > other.x)
            return 1;
        if (x < other.x)
            return -1;

        if (y > other.y)
            return 1;
        if (y < other.y)
            return -1;

        return 0;
    }
}
