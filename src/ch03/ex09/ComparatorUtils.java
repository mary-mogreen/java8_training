package ch03.ex09;

import java.lang.reflect.Field;
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

    public static <T> Comparator<? super T> lexicographicComparator(String... fieldNames) {

        return (o1, o2) -> {
            Comparable<?>[] fields1 = new Comparable[fieldNames.length];
            Comparable<?>[] fields2 = new Comparable[fieldNames.length];

            Class<?> c1 = o1.getClass();
            Class<?> c2 = o2.getClass();
            for (int i = 0; i < fieldNames.length; i++) {
                try {
                    Field f1 = c1.getDeclaredField(fieldNames[i]);
                    Field f2 = c2.getDeclaredField(fieldNames[i]);
                    f1.setAccessible(true);
                    f2.setAccessible(true);
                    fields1[i] = (Comparable<?>) f1.get(o1);
                    fields2[i] = (Comparable<?>) f2.get(o2);
                } catch(NoSuchFieldException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            for (int j = 0; j < fields1.length; j++) {
                int result = ((Comparable<Object>)fields1[j]).compareTo(fields2[j]);
                if (result != 0)
                    return result;
            }
            return 0;
        };
    }
}
