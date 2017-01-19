package ch06.ex07;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class MaxKeyTest {
    private static final long NUM_OF_ENTRY = 1000000L;
    private ConcurrentHashMap<String, Long> map;

    @Before
    public void setup() {
        map = new ConcurrentHashMap<>();
        for (long l = 0L; l < NUM_OF_ENTRY; l++) {
            String key = "testKey_" + l;
            map.put(key, l);
        }
    }

    @Test
    public void testMaxKey() {
        String result = MaxKey.maxKey(map);
        assertEquals("testKey_"+(NUM_OF_ENTRY-1), result);
    }

    @Test(expected = NullPointerException.class)
    public void testMaxKey_null() {
        map = null;
        String result = MaxKey.maxKey(map);
        assertEquals("testKey_"+(NUM_OF_ENTRY-1), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxKey_empty() {
        map = new ConcurrentHashMap<>();
        String result = MaxKey.maxKey(map);
        assertEquals("testKey_"+(NUM_OF_ENTRY-1), result);
    }

    @Test
    public void testMax() throws Exception {
        Map.Entry<String, Long> result = MaxKey.max(map);
        assertEquals("testKey_"+(NUM_OF_ENTRY-1), result.getKey());
        assertEquals(NUM_OF_ENTRY-1, result.getValue().longValue());
    }

    @Test(expected = NullPointerException.class)
    public void testMax_null() {
        map = null;
        Map.Entry<String, Long> result = MaxKey.max(map);
        assertEquals("testKey_"+(NUM_OF_ENTRY-1), result.getKey());
        assertEquals(NUM_OF_ENTRY-1, result.getValue().longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMax_empty() {
        map = new ConcurrentHashMap<>();
        Map.Entry<String, Long> result = MaxKey.max(map);
        assertEquals("testKey_"+(NUM_OF_ENTRY-1), result.getKey());
        assertEquals(NUM_OF_ENTRY-1, result.getValue().longValue());
    }

}