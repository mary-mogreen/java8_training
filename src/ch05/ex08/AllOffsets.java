package ch05.ex08;

import java.time.Instant;
import java.time.ZoneId;

/**
 * Created by mary-mogreen.
 */
public class AllOffsets {
    public static void main(String[] args) {
        Instant now = Instant.now();

        ZoneId.getAvailableZoneIds().stream().forEach(
                id -> {
                    System.out.println(now.atZone(ZoneId.of(id)));
                }
        );
    }
}
