package ch02.ex12;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mary-mogreen.
 */
public class ShortWordCounterTest {

    private static String contents;
    private List<String> words;

    @BeforeClass
    public static void beforeClass() throws IOException {
        contents = new String(Files.readAllBytes(Paths.get("./test/ch02/ex01/alice.txt")), StandardCharsets.UTF_8);
    }

    @Before
    public void before() {
        words = Arrays.asList(contents.split("[\\P{L}]+"));
    }

    @Test
    public void testCount() {
        int[] result = ShortWordCounter.count(words.stream().skip(1), 12);
        int[] result2 = ShortWordCounter.count(words.stream().skip(1), 12);
        for (int i = 1; i < result.length; i++) {
            System.out.printf("word length: %d -> result: %d, result2: %d%n", i, result[i], result2[i]);
        }
    }

    @Test
    public void testCount2() {
        AtomicInteger[] result = ShortWordCounter.count2(words.stream().skip(1), 12);
        AtomicInteger[] result2 = ShortWordCounter.count2(words.stream().skip(1), 12);
        for (int i = 1; i < result.length; i++) {
            assertTrue(result[i].get() == result2[i].get());
            System.out.printf("word2 length: %d -> result: %d, result2: %d%n", i, result[i].get(), result2[i].get());
        }
    }
}
