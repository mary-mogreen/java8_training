package ch02.ex11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class StreamUtils {

    public static <T> List<T> collectStreamToList(Stream<T> stream, int size) {
        Objects.requireNonNull(stream, "stream must not be null.");
        List<T> list = new ArrayList<>(size);
        IntStream.range(0, size).forEach(i -> list.add(null));
        AtomicInteger index = new AtomicInteger();
        stream.parallel().forEach(t -> {
            int i = index.getAndIncrement();
            if (i >= size)
                return;
            list.set(i, t);
        });
        if (index.get() < size)
            return list.subList(0, index.get());
        return list;
    }

    public static double averageStreamDouble(Stream<Double> stream) {
        Objects.requireNonNull(stream, "stream must not be null");
        AtomicLong count = new AtomicLong();
        double sum = stream.reduce(0.0, (x, y) -> {
            count.incrementAndGet();
            return x + y;
        });
        if (count.get() == 0)
            return 0.0;
        return sum / count.get();
    }

    public static <T> ArrayList<T> flatArrayList(Stream<ArrayList<T>> stream) {
        Objects.requireNonNull(stream, "stream must not be null.");
        return stream.reduce(new ArrayList<T>(), (a1, a2) -> { a1.addAll(a2); return a1; });
    }

    public static Stream<Character> characterStream(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        // 終わらないので無理
        // long count = stream.count();
        // System.out.println(count);
        throw new UnsupportedOperationException("");
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        if (first == null || second == null)
            throw new IllegalArgumentException(
                    String.format("%s must not be null.",
                            (second == null) ? ( (first == null) ? "first and second" : "second") : "first"));

        List<T> list = new ArrayList<>();
        Iterator<T> firstItr = first.iterator();
        Iterator<T> secondItr = second.iterator();
        while(firstItr.hasNext() && secondItr.hasNext()) {
            list.add(firstItr.next());
            list.add(secondItr.next());
        }
        return list.stream();
    }

}
