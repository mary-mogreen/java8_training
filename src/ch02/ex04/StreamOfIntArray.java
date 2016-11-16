package ch02.ex04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class StreamOfIntArray {

    public static void main(String[] args) {
        int[] values = {1, 4, 9, 16};
        System.out.println(Stream.of(values).count());// -> 1 int[]のストリーム
        System.out.println(IntStream.of(values).count());// -> 4
    }
}
