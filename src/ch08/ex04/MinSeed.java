package ch08.ex04;

import java.util.Random;
import java.util.stream.LongStream;

/**
 * Created by mary-mogreen.
 */
public class MinSeed {
    private static final long m = 25214903917L;
    private static final long a = 11L;
    private static final long N = 1L << 48;
    private static final long ν = 246154705703781L;

    public static long prev(long s) {
        return (s - a) * ν % N;
    }

    public static void main(String[] args) {
        long min = LongStream.iterate(prev(0), s -> prev(prev(s))).map(n -> Math.abs(n ^ m)).limit(1000000L).min().getAsLong();
        System.out.println(min);
        Random generator = new Random(min);
        for (long l = 1L; ; l++) {
            if (generator.nextDouble() == 0.0) {
                System.out.println("最小のシード: " + min + ", " + l + "回目に0.");
                return;
            }
        }
    }
}
