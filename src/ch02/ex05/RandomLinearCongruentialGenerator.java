package ch02.ex05;

import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class RandomLinearCongruentialGenerator {

    public static Stream<Long> random(long a, long c, long m, long seed) {
        return Stream.iterate(seed, x -> (x * a + c) % m);
    }
}
