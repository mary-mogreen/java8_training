package ch05.ex02;

import java.time.LocalDate;

/**
 * Created by mary-mogreen.
 */
public class LocalDates {
    public static void main(String[] args) {
        LocalDate local = LocalDate.of(2000, 2, 29);

        // １年を加算する。
        System.out.println("1 -> " + local.plusYears(1));
        // ４年を加算する。
        System.out.println("4 -> " + local.plusYears(4));
        // １年を４回加算する。
        System.out.println("1 * 4 -> " + local.plusYears(1).plusYears(1).plusYears(1).plusYears(1));

    }
}
