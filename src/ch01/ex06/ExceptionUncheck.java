package ch01.ex06;

import java.util.concurrent.Callable;

/**
 * Created by mary-mogreen.
 */
public class ExceptionUncheck {

    public static Runnable uncheck(RunnableEx rex) {
        return () -> {
            try {
                rex.run();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static Runnable uncheck2(Callable<Void> c) {
        return () -> {
            try {
                c.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
