package ch02.ex10;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mary-mogreen.
 */
public class StreamUtilsTest {

    private Stream<Double> stream;

    @Before
    public void before() {
        stream = null;
    }

    @Test
    public void testAverageStreamDouble() {
        stream = Stream.of(1.0, 2.0, 30.0);
        double result = StreamUtils.averageStreamDouble(stream);
        assertTrue(11.0 == result);
    }

    @Test
    public void testAverageStreamDouble_empty() {
        stream = Stream.empty();
        double result = StreamUtils.averageStreamDouble(stream);
        assertTrue(0.0 == result);
    }

    @Test(expected = NullPointerException.class)
    public void testAverageStreamDouble_null() {
        double result = StreamUtils.averageStreamDouble(stream);
    }
}
