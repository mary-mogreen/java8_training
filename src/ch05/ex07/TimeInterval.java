package ch05.ex07;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by mary-mogreen.
 */
public class TimeInterval {

    final LocalDateTime start; // この時刻を含む
    final LocalDateTime end; // この時刻を含む

    public TimeInterval(LocalDateTime start, LocalDateTime end) {
        Objects.requireNonNull(start, "start is not null.");
        Objects.requireNonNull(end, "end is not null.");

        if (!start.isBefore(end))
            throw new IllegalArgumentException("start is not before end.");

        this.start = start;
        this.end = end;
    }

    /**
     * 1時から2時と2時から3時は重なっているとみなします。
     */
    public boolean isOverrapping(TimeInterval o) {
        Objects.requireNonNull(o, "the other TimeInterval is not null.");

        if (start.isAfter(o.end) || end.isBefore(o.start))
            return false;

        return true;
    }
}
