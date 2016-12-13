package ch03.ex23;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by mary-mogreen.
 */
public class PairUtilsTest {
    @Test
    public void testMap() {
        Pair<String> pair = new Pair<>("23", "34");
        Pair<Integer> result = PairUtils.map(pair,
                s -> Integer.valueOf(s));

        assertTrue(23 == result.getFirst());
        assertTrue(34 == result.getSecond());
    }

    @Test(expected = NullPointerException.class)
    public void testMap_pairNull() {
        Pair<String> pair = null;
        Pair<Integer> result = PairUtils.map(null,
                s -> Integer.valueOf((String) s));
    }

    @Test(expected = NullPointerException.class)
    public void testMap_funcNull() {
        Pair<String> pair = new Pair<>("test", "tset");
        Pair<Integer> result = PairUtils.map(pair, null);
    }
}
