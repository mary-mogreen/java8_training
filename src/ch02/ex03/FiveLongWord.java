package ch02.ex03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mary-mogreen.
 */
public class FiveLongWord {
    public static void main(String[] args) throws IOException {
        long[][] r = countAlice();
        System.out.printf("alice.txt%ncount: %d, time: %d%nparallel count: %d, time: %d%n", r[0][0], r[0][1], r[1][0], r[1][1]);
        r = countWarAndPeace();
        System.out.printf("warandpeace.txt%ncount: %d, time: %d%nparallel count: %d, time: %d%n", r[0][0], r[0][1], r[1][0], r[1][1]);
    }

    public static long[][] countAlice() throws IOException {

        String contents = new String(Files.readAllBytes(
                Paths.get("./test/ch02/ex01/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long[] count = count(words);
        long[] pcount = parallelCount(words);
        long[][] result = {count, pcount};
        return result;
    }

    public static long[][] countWarAndPeace() throws IOException {

        String contents = new String(Files.readAllBytes(
                Paths.get("./src/ch02/ex03/warandpeace.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long[] count = count(words);
        long[] pcount = parallelCount(words);
        long[][] result = {count, pcount};
        return result;
    }



    public static long[] count(List<String> words) {
        long[] result = new long[2];
        long start = System.nanoTime();
        result[0] = words.stream().filter(s -> s.length() > 12).count();
        result[1] = System.nanoTime() - start;
        return result;
    }

    public static long[] parallelCount(List<String> words) {
        long[] result = new long[2];
        long start = System.nanoTime();
        result[0] = words.parallelStream().filter(s -> s.length() > 12).count();
        result[1] = System.nanoTime() - start;
        return result;
    }
}
