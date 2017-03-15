package ch09.ex06;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mary-mogreen.
 */

/**
 * args[0]: read file
 * args[1]: write file
 */
public class ReverseLines {
    public static void main(String[] args) throws IOException {
        List<String> ordered = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
        List<String> reversed = new ArrayList<>(ordered);
        Collections.reverse(reversed);
        Files.write(Paths.get(args[1]), reversed);
    }
}
