package ch02.ex06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

/**
 * Created by mary-mogreen.
 */
public class StreamUtilsTest {

    public static Stream<Character> characterStream(String s) {
        List<Character> result = new ArrayList<>();
        for (char c: s.toCharArray())
            result.add(c);
        return result.stream();
    }

    @Test
    public void testCharacterStream() {
        String s = "TestCharacterStream";

        List<Character> expected = characterStream(s).collect(Collectors.toList());
        List<Character> actual = StreamUtils.characterStream(s).collect(Collectors.toList());
        assertTrue(expected.equals(actual));
    }
}
