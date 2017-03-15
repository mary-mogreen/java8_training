package ch09.ex07;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class SaveWebPageTest {
    @Test
    public void testMain() {
        try {
            SaveWebPage.main(new String[] {
                "https://en.wikipedia.org/wiki/Java",
                "./test/ch09/ex07/url_out.txt"
            });
        } catch (IOException e) {
            fail(e.toString());
        }
    }

}