package ch02.ex01;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mary-mogreen.
 */
public class ParallelForLoopTest {
    @Test
    public void testCount() throws IOException {
        ParallelForLoop loop = new ParallelForLoop(5, 12);
        String contents = new String(Files.readAllBytes(Paths.get("./test/ch02/ex01/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        long count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println("count: " + count);

        int count2 = loop.count(words);
        System.out.println("count2: " + count2);

        assertEquals(count, count2);
    }
}
