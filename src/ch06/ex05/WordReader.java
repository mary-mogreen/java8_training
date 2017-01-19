package ch06.ex05;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by mary-mogreen.
 */
public class WordReader {
    private final ConcurrentHashMap<String, Set<File>> map;
    private final List<File> files;

    public static void main(String[] args) {
        File f1 = new File("./src/ch02/ex03/warandpeace.txt");
        File f2 = new File("./test/ch02/ex01/alice.txt");
        WordReader wr = new WordReader(f1, f2);
        wr.readWords();
        wr.printMap();
        // wr.printMap(f1);
        // wr.printMap(f2);
    }

    public WordReader(File... files) {
        map = new ConcurrentHashMap<>();
        this.files = Arrays.asList(files);
    }

    public void readWords() {
        files.parallelStream().forEach(file -> {
            try {
                String contents = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
                List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
                Set<File> set = new HashSet<>();
                set.add(file);
                words.parallelStream().forEach(w -> {
                    map.merge(w.toLowerCase(), set, (set1, set2) -> {
                        set1.addAll(set2);
                        return set1;
                    });
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void printMap() {
        map.forEach((s, fs) -> {
            System.out.print("word: " + s + ", files: ");
            fs.forEach(file -> System.out.print(file.getName() + ", "));
            System.out.println();
        });
    }

    public void printMap(File file) {
        map.forEach((s, fs) -> {
            if (fs.contains(file))
                System.out.println("word: " + s + " in " + file.getName());
        });
    }
}
