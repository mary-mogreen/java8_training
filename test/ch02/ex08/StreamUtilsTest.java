package ch02.ex08;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by mary-mogreen.
 */
public class StreamUtilsTest {

    private Stream<String> first;
    private Stream<String> second;
    private Stream<String> zipped;

    @Before
    public void beforeTestZip() {
        first = Stream.of("f1", "f2", "f3", "f4", "f5");
        second = Stream.of("s1", "s2", "s3");
        zipped = null;

    }

    @Test
    public void testZip() {
        Stream<String> zipped = StreamUtils.zip(first, second);
        List<String> expected = Arrays.asList("f1", "s1", "f2", "s2", "f3", "s3");
        assertEquals(expected, zipped.collect(Collectors.toList()));
    }

    @Test
    public void testZip_firstNull() {
        first = null;
        try {
            zipped = StreamUtils.zip(first, second);
        } catch(IllegalArgumentException e) {
            assertEquals("first must not be null.", e.getMessage());
        }

    }

    @Test
    public void testZip_secondNull() {
        second = null;
        try {
            zipped = StreamUtils.zip(first, second);
        } catch(IllegalArgumentException e) {
            assertEquals("second must not be null.", e.getMessage());
        }

    }

    @Test
    public void testZip_null() {
        first = null;
        second = null;
        try {
            zipped = StreamUtils.zip(first, second);
        } catch(IllegalArgumentException e) {
            assertEquals("first and second must not be null.", e.getMessage());
        }
    }
}
