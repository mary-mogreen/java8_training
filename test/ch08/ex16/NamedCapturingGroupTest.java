package ch08.ex16;

import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class NamedCapturingGroupTest {
    @Test
    public void testParse_5keta() {
        String text = "Memphis, TN, 79245";
        String line = NamedCapturingGroup.parse(text);
        assertEquals("city: Memphis, state: TN, zip code: 79245", line);
    }

    @Test
    public void testParse_9keta() {
        String text = "Memphis, TN, 79245-1111";
        String line = NamedCapturingGroup.parse(text);
        assertEquals("city: Memphis, state: TN, zip code: 79245-1111", line);
    }

    @Test
    public void testParse_桁違い() {
        String text = "Memphis, TN, 7924501111";
        String line = NamedCapturingGroup.parse(text);
        assertNotEquals("city: Memphis, state: TN, zip code: 7924501111", line);
        assertEquals(null, line);
    }

}