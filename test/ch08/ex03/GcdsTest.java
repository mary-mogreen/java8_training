package ch08.ex03;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class GcdsTest {
    @Test
    public void testGcd() throws Exception {
        int a = -2498529;
        int b = 43;

        assertTrue(Gcds.gcd1(a, b) == Gcds.gcd2(a, b));
        assertTrue(Gcds.gcd1(a, b) == Gcds.gcd3(a, b));
    }
}