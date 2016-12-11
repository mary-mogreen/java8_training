import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * DefferedLogger
 */
public class DeferredLogger {
    Logger logger;

    public DeferredLogger (Logger logger) {
        this.logger = logger;
    }

    public static void main(String[] args) {
        DeferredLogger dLogger = new DeferredLogger(Logger.getGlobal());
        int i = 0;
        int[] a = new int[11];
        a[10] = 1000;
        dLogger.logIf(Level.FINEST, () -> i == 0, () -> "a[10] = " + a[10]);
    }

    public static void info(Logger logger, Supplier<String> message) {
        if (logger.isLoggable(Level.INFO)) {
            logger.info(message.get());
        }
    }

    
    /**
     * Predicate
     */
    @FunctionalInterface
    public interface MyPredicate {
        boolean test();
    }

    public void logIf(Level level, MyPredicate predicate, Supplier<String> message) {
        if (logger.isLoggable(level)) {
            if (predicate.test())
                logger.log(level, message.get());
        }
    }
} 