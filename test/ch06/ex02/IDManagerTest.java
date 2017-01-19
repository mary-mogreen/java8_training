package ch06.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class IDManagerTest {
    @Test
    public void testNewId(){
        long[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (long e: expected)
            assertEquals(e, IDManager.newId());
    }

}