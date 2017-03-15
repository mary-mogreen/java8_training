package ch09.ex11;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class GrepCreditCard {
    public static void main(String[] args) {
        if (args.length < 1) {
            grep(System.getProperty("user.home"));
        }
        grep(args[0]);
    }

    public static void grep(String dir) {
        InputStream in = exec("grep", "-r", "[0-9]\\{14,16\\}", dir);
        if (in == null)
            return;

        Set<String> cards = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = reader.readLine();
            Pattern pattern = Pattern.compile("[0-9]{14,16}");
            while (line != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    cards.add(matcher.group());
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        cards.stream().forEach(System.out::println);
    }

    public static InputStream exec(String... cmd) {
        Objects.requireNonNull(cmd, "cmd is null.");
        System.out.println("start exec...");
        Stream.of(cmd).forEach(s -> System.out.print(s + " "));
        System.out.println();
        ProcessBuilder pb = new ProcessBuilder(cmd);

        pb.redirectErrorStream(true);
        try {
            Process p = pb.start();
            p.waitFor();
            return p.getInputStream();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
