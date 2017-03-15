package ch09.ex10;

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

        return Objects.equals(label, o.label) && x == o.x && y == o.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, x, y);
    }


    public int compareTo(LabeledPoint other) {
        int diff = label.compareTo(other.label);
        if (diff != 0) return diff;
        diff = Integer.compare(x, other.x); // No risk of overflow
        if (diff != 0) return diff;
        return Integer.compare(y, other.y);
    }
}
