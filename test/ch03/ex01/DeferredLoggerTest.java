import java.util.logging.Level;
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
        DeferredLogger.logIf(Level.FINEST, () -> i == 0, () -> "a[10] = " + a[10]);
    }
}