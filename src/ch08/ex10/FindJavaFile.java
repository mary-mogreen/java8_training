package ch08.ex10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class FindJavaFile {
    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            throw new IllegalArgumentException("require jdk src.zip path");
        String[] keywords;
        if (args.length >= 2) {
            keywords = new String[args.length - 1];
            for (int i = 1; i < args.length; i++)
                keywords[i - 1] = args[i];
        } else {
            keywords = new String[2];
            keywords[0] = "transient";
            keywords[1] = "volatile";
        }
        List<String> files = search(args[0], keywords);
        files.stream().forEach(System.out::println);
    }

    public static List<String> search(String srcPath, String[] keywords) throws IOException {
        Objects.requireNonNull(srcPath, "jdk src.zip path is null.");
        Objects.requireNonNull(keywords, "keywords is null.");

        Path src = Paths.get(srcPath);

        if (!src.toFile().exists())
            throw new FileNotFoundException("jdk src.zip not found");
        if (!src.toFile().isDirectory())
            throw new IllegalArgumentException("is not directory.");

        try (Stream<Path> paths = Files.walk(src)) {
            return paths.filter(path -> path.toFile().isFile()).filter(path -> path.toString().contains(".java")).filter(path -> {
                try {
                    List<String> lines = Files.readAllLines(path);
                    for (String l: lines) {
                        for (String keyword: keywords) {
                            if (l.contains(keyword))
                                return true;
                        }
                    }
                    return false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }).map(path -> path.toAbsolutePath().toString()).collect(Collectors.toList());
        }
    }
}
