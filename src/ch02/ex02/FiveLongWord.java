package ch02.ex02;

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
        System.out.println("alice.txt: " + countAlice());
    }

    public static long countAlice() throws IOException {
        String contents = new String(Files.readAllBytes(
                Paths.get("./test/ch02/ex01/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long count = words.stream().filter(s -> s.length() > 12)
                .peek(s -> System.out.println("filter: " + s)).limit(5).count();
        return count;
    }
}
