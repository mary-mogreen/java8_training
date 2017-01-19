package ch06.ex01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class StringManagerTest {
    @Test
    public void testGetLongestString() {
        String expected = "gwiehiwhgiohwo";
        String[] strArr = {"aaa", "bbbb", "oiehgoiw", expected, "woiheiwegh", "gwieghwo", "waf", "egwogjwp"};
        List<String> strs = new ArrayList<>();
        for (String s: strArr)
            strs.add(s);
        assertEquals(expected, StringManager.getLongestString(strs));
    }

    @Test(expected = NullPointerException.class)
    public void testGetLongestString_null() {
        StringManager.getLongestString(null);
    }

}