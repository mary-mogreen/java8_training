package ch05.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by mary-mogreen.
 */
public class Cal {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("ex) $java Cal 3 2013");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        LocalDate theFirst = LocalDate.of(year, month, 1);

        DayOfWeek dow = theFirst.getDayOfWeek();

        for (int i = DayOfWeek.MONDAY.getValue(); i < dow.getValue(); i++) {
            System.out.print("   ");
        }

        for (LocalDate l = theFirst, theLast = theFirst.plusMonths(1); !l.isEqual(theLast) ; l = l.plusDays(1)) {
            System.out.printf("%3d", l.getDayOfMonth());
            if (l.getDayOfWeek() == DayOfWeek.SUNDAY)
                System.out.println();
        }
        System.out.println();

    }
}
