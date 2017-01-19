package ch05.ex10;

import java.time.*;

/**
 * Created by mary-mogreen.
 */
public class TimeDifference {
    public static void main(String[] args) {
        String LOSANGELES = "America/Los_Angeles";
        String FRANKFURT = "Europe/Berlin";
        TimeDifference td = new TimeDifference(ZoneId.of(LOSANGELES), ZoneId.of(FRANKFURT));
        td.getArrivalTime(LocalDateTime.of(2017, 1, 17, 3, 5), 10 * 60 + 50);
    }
    private ZoneId from;
    private ZoneId to;


    public TimeDifference(ZoneId from, ZoneId to) {
        this.from = from;
        this.to = to;
    }

    public ZonedDateTime getArrivalTime(LocalDateTime start, long flightTimeMinutes) {
        ZonedDateTime fromTime = start.atZone(from);
        System.out.println("departure time: " + fromTime);
        ZonedDateTime toTime = fromTime.plusMinutes(flightTimeMinutes).toInstant().atZone(to);
        System.out.println("arrival time: " + toTime);
        return toTime;
    }
}
