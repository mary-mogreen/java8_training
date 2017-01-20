package ch05.ex01;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created by mary-mogreen.
 */
public class ProgrammersDay {
    public static void main(String[] args) {
        System.out.println("programmer's day: " + programmersDay(2014));
    }

    public static LocalDate programmersDay(int year) {
        return LocalDate.of(year, 1, 1).plus(Period.ofDays(255));
    }
}
