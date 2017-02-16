package ch08.ex02;

import org.junit.Test;


/**
 * Created by mary-mogreen.
 */
public class ExceptionNTest {
    @Test (expected = ArithmeticException.class)
    public void testNegateExact() {
        Math.negateExact(Integer.MIN_VALUE);
    }
}