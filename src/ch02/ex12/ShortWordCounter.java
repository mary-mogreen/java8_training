package ch02.ex12;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class ShortWordCounter {

    public static int[] count(Stream<String> words, int length) {
        int[] shortWords = new int[length];
        words.parallel().forEach(
                w -> {
                    if (w.length() < length)
                        shortWords[w.length()]++;
                }
        );
        return shortWords;
    }

    public static AtomicInteger[] count2(Stream<String> words, int length) {
        AtomicInteger[] shortWords = new AtomicInteger[length];
        for (int i = 0; i < length; i++)
            shortWords[i] = new AtomicInteger();
        words.parallel().forEach(
                w -> {
                    if (w.length() < length)
                        shortWords[w.length()].getAndIncrement();
                }
        );
        return shortWords;
    }
}
