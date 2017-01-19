package ch05.ex11;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by mary-mogreen.
 */
public class TimeDifference {
    public static void main(String[] args) {
        String LOSANGELES = "America/Los_Angeles";
        String FRANKFURT = "Europe/Berlin";
        TimeDifference td = new TimeDifference(ZoneId.of(FRANKFURT), ZoneId.of(LOSANGELES));
        long minutes = td.getFlightTimeMinutes(LocalDateTime.of(2017, 1, 17, 14, 5), LocalDateTime.of(2017, 1, 17, 16, 40));
        System.out.println("flight time: " + (minutes / 60) + "時間 " + (minutes % 60) + "分");
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

    public long getFlightTimeMinutes(LocalDateTime fromTime, LocalDateTime toTime) {
        ZonedDateTime fromZonedTime = fromTime.atZone(from);
        ZonedDateTime toZonedTime = toTime.atZone(to);
        return (toZonedTime.toEpochSecond() - fromZonedTime.toEpochSecond()) / 60;
    }
}
