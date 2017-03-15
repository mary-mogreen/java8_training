package ch09.ex09;

import java.util.Objects;

/**
 * Created by mary-mogreen.
 */
public class LabeledPoint {
    private String label;
    private int x, y;

    public LabeledPoint(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof LabeledPoint))
            return false;

        LabeledPoint o = (LabeledPoint) other;

        return Objects.equals(label, o.label) && 0 == compareTo(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, x, y);
    }

    public int compareTo(LabeledPoint other) {
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
