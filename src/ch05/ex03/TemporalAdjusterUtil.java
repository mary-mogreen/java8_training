package ch05.ex03;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.function.Predicate;

/**
 * Created by mary-mogreen.
 */
public class TemporalAdjusterUtil {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("today: " + today);
        LocalDate next = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
        System.out.println("next: " + next);
    }

    public static TemporalAdjuster next(Predicate<LocalDate> p) {
        return w -> {
          LocalDate result = (LocalDate) w;
          do {
              result = result.plusDays(1);
          } while (!p.test(result));
            return result;
        };
    }
}
