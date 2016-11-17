package ch02.ex07;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class StreamUtils {

    public static Stream<Character> characterStream(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        // 終わらないので無理
        // long count = stream.count();
        // System.out.println(count);
        throw new UnsupportedOperationException("");
    }

    public static void main(String[] args) {
        // isFinite(Stream.generate(() -> ""));
    }
}
