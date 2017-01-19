package ch06.ex01;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by mary-mogreen.
 */
public class StringManager {
    private static AtomicReference<String> stringAtomicReference = new AtomicReference<>("");

    private static void updateIfLongest(String s) {
        stringAtomicReference.accumulateAndGet(s, (s1, s2) -> {
            return s1.length() > s2.length() ? s1: s2;
        });
    }

    public static String getLongestString(List<String> strings) {
        Objects.requireNonNull(strings, "string list is null.");

        strings.parallelStream().forEach(StringManager::updateIfLongest);
        return stringAtomicReference.get();
    }


}
