package ch05.ex01;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class ProgrammersDayTest {
    @Test
    public void programmersDay_leapYear() {
        LocalDate expected = LocalDate.of(2016, 1, 1).plusDays(255);
        assertEquals(expected, ProgrammersDay.programmersDay(2016, 1, 1));
        System.out.println("leap year: " + expected);
    }

    @Test
    public void programmersDay_notLeapYear() {
        LocalDate expected = LocalDate.of(2015, 1, 1).plusDays(255);
        assertEquals(expected, ProgrammersDay.programmersDay(2015, 1, 1));
        System.out.println("leap year: " + expected);
    }

}