package ch03.ex21;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;

/**
 * Created by mary-mogreen.
 */
public class FutureUtilsTest {
    @Test
    public void testMap() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        AtomicInteger result = new AtomicInteger(11);
        Future<AtomicInteger> intFuture = executor.submit(() -> {
            result.getAndIncrement();
        }, result);
        Future<String> strFuture = FutureUtils.map(intFuture,
                (i) -> Integer.toString(i.get()));

        try {
            assertTrue(strFuture.get().equals("12"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
