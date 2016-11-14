package ch01.ex06;

import org.junit.Test;

/**
 * Created by mary-mogreen.
 */
public class ExceptionUncheckTest {

    @Test
    public void testUncheck() {
        new Thread(ExceptionUncheck.uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);})).start();
    }

    @Test
    public void testUncheck2() {
        new Thread(ExceptionUncheck.uncheck2(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
            return null; // return null が必要.
        })).start();
    }
}
