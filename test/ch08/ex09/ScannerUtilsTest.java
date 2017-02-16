package ch08.ex09;

import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class ScannerUtilsTest {
    @Test
    public void toWordStream() throws Exception {
        Scanner scanner = new Scanner(new File("./test/ch02/ex01/alice.txt"));
        scanner.useDelimiter("[\\P{L}]+");
        long count = ScannerUtils.toWordStream(scanner).filter(s -> s.length() > 12).count();
        String contents = new String(Files.readAllBytes(
                Paths.get("./test/ch02/ex01/alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        long expected = words.stream().skip(1).filter(s -> s.length() > 12).count();
        System.out.println(expected + ", " + count);
        assertTrue(expected == count);
    }

    @Test
    public void toLineStream() throws Exception {
        Scanner scanner = new Scanner(new File("./test/ch02/ex01/alice.txt"));

        List<String> lines = ScannerUtils.toLineStream(scanner).collect(Collectors.toList());

        List<String> expected = Files.readAllLines((Paths.get("./test/ch02/ex01/alice.txt")), StandardCharsets.UTF_8);

        System.out.println(expected.size() + ", " + lines.size());
        assertEquals(expected, lines);
    }

    @Test
    public void toIntegerStream() throws Exception {
        String fib = "0 1 1 2 3 5 8 13 21 34 55 89 144 233";
        Scanner scanner = new Scanner(fib);
        List<Integer> ints = ScannerUtils.toIntegerStream(scanner).collect(Collectors.toList());

        List<Integer> expected = new ArrayList<>();
        for (String s: fib.split(" "))
            expected.add(new Integer(s));
        assertEquals(expected, ints);
    }

    @Test
    public void toDoubleStream() throws Exception {
        String fib = "0.0 1.0 1.0 2.0 3.0 5.0 8.0 13.0 21.0 34.0 55.0 89.0 144.0 233.0";
        Scanner scanner = new Scanner(fib);
        List<Double> doubles = ScannerUtils.toDoubleStream(scanner).collect(Collectors.toList());

        List<Double> expected = new ArrayList<>();
        for (String s: fib.split(" "))
            expected.add(new Double(s));
        assertEquals(expected, doubles);
    }

}