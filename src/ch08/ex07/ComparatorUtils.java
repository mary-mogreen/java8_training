package ch08.ex07;

import java.util.Comparator;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;

/**
 * Created by mary-mogreen.
 */
public class ComparatorUtils {

    public static <T extends Comparable<T>> Comparator<T> nullsFirstReversed() {
        return nullsLast(reverseOrder());
    }

}
