package ch09.ex06;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class ReverseLinesTest {
    @Test
    public void testMain() throws Exception {
        try {
            ReverseLines.main(new String[] {
                    "./test/ch02/ex01/alice.txt",
                    "./test/ch09/ex06/alice_reverse.txt"
            });
        } catch (IOException e) {
            fail(e.toString());
        }
    }

}