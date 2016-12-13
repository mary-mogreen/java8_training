package ch03.ex16;

import jdk.jfr.events.ThrowablesEvent;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by mary-mogreen.
 */
public class AsyncException {

    public static <T> void doInOrderAsync(
            Supplier<T> first, BiConsumer<T, Throwable> second,
            Consumer<Throwable> handler) {
        Thread t = new Thread(() -> {
            try {
                T result = first.get();
                try {
                    second.accept(result, null);
                } catch(Throwable ex1) {
                    handler.accept(ex1);
                }
            } catch (Throwable ex2) {
                try {
                    second.accept(null, ex2);
                } catch(Throwable ex3) {
                    handler.accept(ex3);
                }
            }
        });
        t.start();
    }
}

