package ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class grep {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("grep <pattern> <filepath>");
            return;
        }
        try {
            grep(args[0], args[1]);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static void grep(String pattern, String filepath) throws IOException {
        Stream<String> list = Files.lines(Paths.get(filepath));
        list.filter(Pattern.compile(pattern).asPredicate()).forEach(System.out::println);
    }
}
