package ch03.ex20;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by mary-mogreen.
 */
public class ListUtilsTest {

    @Test
    public void testMap() {
        List<Double> doubleList = new ArrayList<>();
        for (Double d = 0.0; d < 10.0; d++)
            doubleList.add(d);
        List<Integer> intList = ListUtils.map(doubleList,
                (d) -> d.intValue() + 10);
        for (int i = 0; i < 10; i++) {
            assertTrue((intList.get(i) == i + 10));
        }
    }

    @Test(expected = NullPointerException.class)
    public void testMap_listNull() {
        List<String> strList = null;
        List<String> internList = ListUtils.map(strList,
                (s) -> s.intern());
    }

    @Test(expected = NullPointerException.class)
    public void testMap_funcNull() {
        List<String> strList = new ArrayList<>();
        List<String> internList = ListUtils.map(strList, null);
    }

    @Test
    public void testMap_empty() {
        List<Integer> intList = new ArrayList<>();
        List<String> strList = ListUtils.map(intList,
                (i) -> i.toString());
        assertTrue(strList.isEmpty());
    }
}
