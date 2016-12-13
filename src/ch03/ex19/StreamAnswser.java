package ch03.ex19;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * Created by mary-mogreen.
 */
public class StreamAnswser<T> {
    public <U> U reduce(U identity, BiFunction<? super U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        // ? super Uとすべきでない。BiFunctionの最初の型引数は返り値なので。
        return null;
    }
}
