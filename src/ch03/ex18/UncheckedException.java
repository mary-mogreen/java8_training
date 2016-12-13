package ch03.ex18;

import java.util.function.Function;

/**
 * Created by mary-mogreen.
 */
public class UncheckedException {

    public static <T, U> Function<T, U> unchecked(ThrowableFunction<T, U> f) {
        return (t) -> {
            try {
                return f.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (Throwable th) {
                throw th;
            }

        };
    }

    @FunctionalInterface
    public interface ThrowableFunction<T, U> {
       U apply(T t) throws Exception;
   }
}

