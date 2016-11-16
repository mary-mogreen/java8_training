package ch02.ex06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class StreamUtils {

    public static Stream<Character> characterStream(String s) {
        return IntStream.range(0, s.length()).mapToObj(s::charAt);
    }
}
