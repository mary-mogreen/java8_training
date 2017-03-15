package ch09.ex05;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class ReverseCharacterTest {
    @Test
    public void testMain() {
        try {
            ReverseCharacter.main(new String[] {
                    "./test/ch02/ex01/alice.txt",
                    "./test/ch09/ex05/alice_reverse.txt"
            });
        } catch (IOException e) {
            fail(e.toString());
        }
    }

}