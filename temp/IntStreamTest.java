import java.util.Collections;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by mary-mogreen.
 */
public class IntStreamTest {
    public static void main(String[] args) {
        long m = (long)Math.pow(2, 48);
        long mm = (1L << 48) - 1;
        long cc = 0x5DEECE66DL;
        long c = 25214903917L;
        long ans = (11L * c + 11L)&mm;
        long ans2 = (11L * c + 11L)%m;
        System.out.printf("%d%n%d%n%d%n%d%n%d%n%d", m, mm, c, cc, ans, ans2);

    }
}
