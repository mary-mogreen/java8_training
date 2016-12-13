package ch03.ex23;

import java.util.Objects;
import java.util.function.Function;

/**
 * Created by mary-mogreen.
 */
public class PairUtils {

    public static <T, U> Pair<U> map(Pair<T> pair, Function<T, U> function) {
        Objects.requireNonNull(pair, "pair is null");
        Objects.requireNonNull(function, "function is null");
        return new Pair<>(function.apply(pair.getFirst()), function.apply(pair.getSecond()));
    }
}
