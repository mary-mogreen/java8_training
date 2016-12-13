package ch03.ex17;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by mary-mogreen.
 */
public class AsyncException {

    public static void doInParallelAsync(
            Runnable first, Runnable second, Consumer<Throwable> handler) {
        Thread t1 = new Thread(() -> {
            try {
                first.run();
            } catch(Throwable t) {
                handler.accept(t);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                second.run();
            } catch(Throwable t) {
                handler.accept(t);
            }
        });

        t1.start();
        t2.start();
    }
}

