package ch03.ex07;

import java.util.Comparator;
import java.util.Set;

/**
 * Created by mary-mogreen.
 */
public class ComparatorUtils {

    public enum Rules {
        REVERSED,
        CASE_INSENSITIVE,
        SPACE_EXCLUDED
    }

    public static Comparator<String> generate(Set<Rules> rules) {

        return (o1, o2) -> {
            String s1 = o1;
            String s2 = o2;

            if (rules.contains(Rules.SPACE_EXCLUDED)) {
                s1.replaceAll("\\s", "");
                s2.replaceAll("\\s", "");
            }

            if (rules.contains(Rules.REVERSED)) {
                String tmp = s1;
                s1 = s2;
                s2 = tmp;
            }

            int result = s1.compareTo(s2);
            if (rules.contains(Rules.CASE_INSENSITIVE)) {
                result = s1.compareToIgnoreCase(s2);
            }

            return result;
        };

    }
}
