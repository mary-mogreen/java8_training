package ch08.ex01;

/**
 * Created by mary-mogreen.
 */
public class UnsignedOperation {

    public static int add(int x, int y) {
        return (int )(Integer.toUnsignedLong(x) + Integer.toUnsignedLong(y));
    }

    public static int sub(int x, int y) {
        return (int )(Integer.toUnsignedLong(x) - Integer.toUnsignedLong(y));
    }

    public static int div(int x, int y) {
        return (int )(Integer.toUnsignedLong(x) / Integer.toUnsignedLong(y));
    }

    public static int compare(int x, int y) {
        long uX = Integer.toUnsignedLong(x);
        long uY = Integer.toUnsignedLong(y);

        return (uX == uY) ? 0: (uX > uY ? 1: -1);
    }
}
