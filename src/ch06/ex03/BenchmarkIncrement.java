package ch06.ex03;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Supplier;

/**
 * Created by mary-mogreen.
 */
public class BenchmarkIncrement {
    private static final int THREADS = 1000;
    private static final int TEST_TIMES = 100000;
    private static final int WAIT_MINUTES = 2;

    public static void main(String[] args) {
        benchmark(() -> incrementAtomicLong(), "AtomicLong ver.");
        benchmark(() -> incrementLongAdder(), "LongAdder ver.");
    }

    public static void benchmark(Runnable r, String title) {
        Instant start = Instant.now();
        r.run();
        Instant end = Instant.now();
        System.out.println(title + ": " + Duration.between(start, end).toMillis() + "ms.");
    }

    public static <T> void benchmark(Supplier<T> s, String title) {
        Instant start = Instant.now();
        T result = s.get();
        Instant end = Instant.now();
        System.out.println(title + ": " + Duration.between(start, end).toMillis() + "ms. result: " + result);
    }

    public static long incrementAtomicLong() {
        AtomicLong num = new AtomicLong();
        ExecutorService threads = Executors.newFixedThreadPool(THREADS);
        for (int i = 0; i < THREADS; i++) {
            threads.execute(() -> {
                for (int j = 0; j < TEST_TIMES; j++)
                    num.incrementAndGet();
            });
        }
        try {
            threads.shutdown();
            threads.awaitTermination(WAIT_MINUTES, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
        return num.get();
    }

    public static long incrementLongAdder() {
        LongAdder num = new LongAdder();
        ExecutorService threads = Executors.newFixedThreadPool(THREADS);
        for (int i = 0; i < THREADS; i++) {
            threads.execute(() -> {
                for (int j = 0; j < TEST_TIMES; j++)
                    num.increment();
            });
        }
        try {
            threads.shutdown();
            threads.awaitTermination(WAIT_MINUTES, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
        return num.sum();
    }
}
