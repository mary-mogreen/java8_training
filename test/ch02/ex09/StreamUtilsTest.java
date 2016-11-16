package ch02.ex09;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mary-mogreen.
 */
public class StreamUtilsTest {

    private List<ArrayList<String>> lists;
    private List<String> expected;
    private List<String> result;

    @Before
    public void before() {
        lists = new ArrayList<>();
        expected = new ArrayList<>();
        result = null;
    }


    @Test
    public void testFlatArrayList() {

        for (int i = 0; i < 10; i++) {
            lists.add(new ArrayList<>(Arrays.asList("a"+i, "b"+i, "c"+i)));
            expected.add("a" + i);
            expected.add("b" + i);
            expected.add("c" + i);
        }
        result = StreamUtils.flatArrayList(lists.stream());

        assertEquals(expected, result);
    }

    @Test
    public void testFlatArrayList_empty() {
        result = StreamUtils.flatArrayList(lists.stream());
        assertEquals(expected, result);

    }

    @Test(expected = NullPointerException.class)
    public void testFlatArrayList_null() {
        lists = null;
        result = StreamUtils.flatArrayList(lists.stream());
    }
}
