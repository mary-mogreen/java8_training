package ch05.ex09;

import java.time.*;

/**
 * Created by mary-mogreen.
 */
public class OffsetsLessThan1Hour {
    public static void main(String[] args) {
        Instant now = Instant.now();

        ZoneId.getAvailableZoneIds().stream().forEach(
                id -> {
                    ZoneOffset offset = now.atZone(ZoneId.of(id)).getOffset();
                    int second = offset.getTotalSeconds();
                    if (second > -60 * 60 && second < 60 * 60)
                        System.out.println(now.atZone(ZoneId.of(id)));
                }
        );
    }
}
