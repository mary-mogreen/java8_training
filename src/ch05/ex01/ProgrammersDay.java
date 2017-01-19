package ch05.ex01;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created by mary-mogreen.
 */
public class ProgrammersDay {
    public static void main(String[] args) {
        System.out.println("programmer's day: " + programmersDay(2014, 1, 1));
    }

    public static LocalDate programmersDay(int year, int month, int dayOfMonth) {
        return LocalDate.of(year, month, dayOfMonth).plus(Period.ofDays(255));
    }
}
