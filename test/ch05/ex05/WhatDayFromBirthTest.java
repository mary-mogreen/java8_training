package ch05.ex05;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class WhatDayFromBirthTest {
    @Test
    public void testShow() throws Exception {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        long expected = 1;
        assertEquals(expected, WhatDayFromBirth.show(yesterday));
    }

}