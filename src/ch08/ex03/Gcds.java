package ch08.ex03;

/**
 * Created by mary-mogreen.
 */
public class Gcds {

    public static int gcd1(int a, int b) {
        if (b == 0)
            return a < 0 ? -a: a;
        return gcd1(b, a % b);
    }

    public static int gcd2(int a, int b) {
        if (b == 0)
            return a < 0 ? -a: a;
        return gcd2(b, Math.floorMod(a, b));
    }

    public static int gcd3(int a, int b) {
        if (b == 0)
            return a < 0 ? -a: a;
        return gcd3(b, rem(a, b));
    }

    private static int rem(int a, int b) {
        int rem = a % b;
        return rem < 0? -rem: rem;
    }
}
