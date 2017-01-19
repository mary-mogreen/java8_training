package ch06.ex07;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mary-mogreen.
 */
public class MaxKey {

    private static final long THRESHOLD = 100L;
    private static final long NUM_OF_ENTRY = 1000000L;
    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        for (long l = 0L; l < NUM_OF_ENTRY; l++) {
            String key = "testKey_" + l;
            map.put(key, l);
        }

        Map.Entry<String, Long> entry = map.reduceEntries(THRESHOLD, (e1, e2) -> {
           return e1.getValue() > e2.getValue() ? e1: e2;
        });

        System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    }

    public static String maxKey(ConcurrentHashMap<String, Long> map) {
        Objects.requireNonNull(map, "map is null");
        if (map.isEmpty())
            throw new IllegalArgumentException("map is empty.");
        return max(map).getKey();
    }

    public static Map.Entry<String, Long> max(ConcurrentHashMap<String, Long> map) {
        Objects.requireNonNull(map, "map is null");
        if (map.isEmpty())
            throw new IllegalArgumentException("map is empty.");
        return map.reduceEntries(THRESHOLD, (e1, e2) -> {
            return e1.getValue() > e2.getValue() ? e1: e2;
        });
    }
}
