package ch05.ex05;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by mary-mogreen.
 */
public class WhatDayFromBirth {
    public static void main(String[] args) {
        LocalDate birthDay;
        if (args.length == 3) {
            birthDay = LocalDate.of(parseInt(args[0]), parseInt(args[1]), parseInt(args[2]));
        } else {
            System.out.println("ex) $java WhatDayFromBirth 1992 4 25");
            birthDay = LocalDate.of(1992, 4, 25);
        }
        show(birthDay);
    }

    public static long show(LocalDate birthDay) {
        long whatDayFromBirth = birthDay.until(LocalDate.now(), ChronoUnit.DAYS);
        System.out.println("Happy " + whatDayFromBirth + " day of birth!");
        return whatDayFromBirth;
    }

    private static int parseInt(String num) {
        return Integer.parseInt(num);
    }
}
