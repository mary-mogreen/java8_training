package ch03.ex01;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;


/**
 * name
 */
public class DeferredLoggerTest {

    @Test
    public void testLogIf() {
        int i = 0;
        int[] a = new int[11];
        a[10] = 1000;
        DeferredLogger logger = new DeferredLogger(Logger.getGlobal());
        logger.logIf(Level.FINEST, () -> i == 0, () -> "a[10] = " + a[10]);
    }
}