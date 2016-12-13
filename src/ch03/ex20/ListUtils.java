package ch03.ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * Created by mary-mogreen.
 */
public class ListUtils {

    public static <T, U> List<U> map(List<T> list, Function<T, U> function) {
        Objects.requireNonNull(list, "list is null");
        Objects.requireNonNull(function, "function is null");

        List<U> out = new ArrayList<>();
        for (T t: list) {
            out.add(function.apply(t));
        }
        return out;
    }

}
