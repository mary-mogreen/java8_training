package ch05.ex03;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class TemporalAdjusterUtilTest {
    @Test
    public void testNext_20170116() throws Exception {
        LocalDate date20170116 = LocalDate.of(2017, 1, 16);
        LocalDate expected = LocalDate.of(2017, 1, 17);
        assertEquals(expected, date20170116.with(TemporalAdjusterUtil.next(w -> w.getDayOfWeek().getValue() < 6)));
    }

    @Test
    public void testNext_java8() throws Exception {
        LocalDate date20170116 = LocalDate.of(2017, 1, 20);
        LocalDate expected = LocalDate.of(2017, 1, 23);
        assertEquals(expected, date20170116.with(TemporalAdjusterUtil.next(w -> w.getDayOfWeek().getValue() < 6)));
    }

}