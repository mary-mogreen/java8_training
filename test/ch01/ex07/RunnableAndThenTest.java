package ch01.ex07;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mary-mogreen.
 */
public class RunnableAndThenTest {
    @Test
    public void testAndThen() {
        List<String> list = new ArrayList<>();
        Runnable r = RunnableAndThen.andThen(() -> {
            list.add("first");
        }, () -> {
            list.add("second");
        });

        r.run();

        assertEquals("first", list.get(0));
        assertEquals("second", list.get(1));

    }
}
