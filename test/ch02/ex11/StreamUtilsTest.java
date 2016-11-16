package ch02.ex11;

import ch02.ex10.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mary-mogreen.
 */
public class StreamUtilsTest {

    private List<Double> expected;
    private Stream<Double> stream;
    private List<Double> result;

    @Before
    public void before() {
        expected = Arrays.asList(10.0, 21.0, 23.0, 4.0, 3.2, 2.2);
        stream = expected.stream();
        result = null;
    }
    @Test
    public void testCollectStreamToList() {
        result = StreamUtils.collectStreamToList(stream, expected.size());
        assertTrue(result.size() == expected.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    public void testCollectStreamToList_small() {
        result = StreamUtils.collectStreamToList(stream, expected.size() - 1);
        assertTrue(result.size() == expected.size() - 1);
        assertTrue(expected.containsAll(result));
    }

    @Test
    public void testCollectStreamToList_large() {
        result = StreamUtils.collectStreamToList(stream, expected.size() + 1);
        assertTrue(result.size() == expected.size());
        assertTrue(expected.containsAll(result));
    }

    @Test(expected = NullPointerException.class)
    public void testCollectStreamToList_null() {
        result = StreamUtils.collectStreamToList(null, expected.size());
        assertTrue(result.size() == expected.size());
        assertTrue(expected.containsAll(result));
    }

    @Test
    public void testCollectStreamToList_zero() {
        result = StreamUtils.collectStreamToList(stream, 0);
        assertTrue(result.isEmpty());
    }
}
