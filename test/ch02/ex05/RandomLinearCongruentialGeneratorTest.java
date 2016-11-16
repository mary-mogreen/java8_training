package ch02.ex05;

import org.junit.Test;

import java.util.Random;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by mary-mogreen.
 */
public class RandomLinearCongruentialGeneratorTest {

    @Test
    public void testRandom() {
        long a = 2521490391L;
        long c = 11L;
        long m = LongStream.generate(() -> 2L).limit(48).reduce(1, (x, y) -> x * y);
        // long checkm = (long)Math.pow(2, 48);
        // assertEquals(m, checkm);
        Stream<Long> r = RandomLinearCongruentialGenerator.random(a, c, m, 0L);

        Long[] x = r.limit(2).toArray(Long[]::new);
        assertEquals(0L, x[0].longValue());
        assertEquals(11L, x[1].longValue());
    }
}
