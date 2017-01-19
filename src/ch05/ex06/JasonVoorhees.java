package ch05.ex06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by mary-mogreen.
 */
public class JasonVoorhees {
    public static void main(String[] args) {
        int start = 1901;
        int end = 2000;

        for (int year = start; year <= end; year++) {
            for (Month month: Month.values()) {
                LocalDate fridayThe13th = LocalDate.of(year, month.getValue(), 13);
                if (fridayThe13th.getDayOfWeek() == DayOfWeek.FRIDAY)
                    System.out.println(fridayThe13th);
            }

        }
    }
}
