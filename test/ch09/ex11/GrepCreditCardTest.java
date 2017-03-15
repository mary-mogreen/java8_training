package ch09.ex11;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class GrepCreditCardTest {
    @Test
    public void testGrep() throws Exception {
        GrepCreditCard.grep("./test/testDir");
    }

}