package ch02.ex09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class StreamUtils {
    
    // TODO 3つの形式で
    // Optional<T>	reduce(BinaryOperator<T> accumulator)
    // <U> U	reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
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
