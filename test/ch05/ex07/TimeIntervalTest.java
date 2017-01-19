package ch05.ex07;

import com.sun.scenario.animation.shared.TimerReceiver;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class TimeIntervalTest {

    @Test (expected = NullPointerException.class)
    public void testTimeInterval_nullArgument() {

        TimeInterval timeInterval1 = new TimeInterval(null, null);

    }

    @Test
    public void testIsOverrapping() throws Exception {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMinutes(1);

        TimeInterval timeInterval1 = new TimeInterval(start, end);
        TimeInterval timeInterval2 = new TimeInterval(start, end);

        assertTrue(timeInterval1.isOverrapping(timeInterval2));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testIsOverrapping_endIsBeforeStart() throws Exception {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().minusMinutes(1);

        TimeInterval timeInterval1 = new TimeInterval(start, end);
    }

    @Test
    public void testIsOverrapping_notOverrapping() throws Exception {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMinutes(1);

        TimeInterval timeInterval1 = new TimeInterval(start, end);
        TimeInterval timeInterval2 = new TimeInterval(end.plusMinutes(1), end.plusMinutes(2));

        assertFalse(timeInterval1.isOverrapping(timeInterval2));
    }

    @Test(expected = NullPointerException.class)
    public void testIsOverrapping_otherTimeIntervalIsNull() throws Exception {
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusMinutes(1);

        TimeInterval timeInterval1 = new TimeInterval(start, end);

        assertFalse(timeInterval1.isOverrapping(null));
    }

}