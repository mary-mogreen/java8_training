package ch08.ex16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by mary-mogreen.
 */
public class NamedCapturingGroup {
    private static final String cityPattern = "(?<city>[\\p{L} ]+)";
    private static final String statePattern = "(?<state>[A-Z]{2})";
    private static final String zipcodePattern = "(?<zipcode>\\d{5}|\\d{5}-\\d{4})";

    private static final Pattern pattern = Pattern.compile(String.join(", \\s*", cityPattern, statePattern, zipcodePattern));

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("java NamedCapturingGroup <filepath>");
            return;
        }

        Stream<String> lines = Files.lines(Paths.get(args[0]));
        lines.forEach(s -> System.out.println(parse(s)));
    }
    public static String parse(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            String city = matcher.group("city");
            String state = matcher.group("state");
            String zipCode = matcher.group("zipcode");
            return String.format("city: %s, state: %s, zip code: %s", city, state, zipCode);
        }
        return null;
    }
}
