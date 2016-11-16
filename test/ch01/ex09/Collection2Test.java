package ch01.ex09;

import org.junit.Test;

/**
 * Created by mary-mogreen.
 */
public class Collection2Test {

    @Test
    public void testForEachIf() {
        ArrayList2<String> list = new ArrayList2<>();
        list.add("****");
        list.add("*********");
        list.add("*****");
        list.add("***");
        list.add("*******");
        list.add("*");
        list.add("*****");

        list.forEachIf(s -> { System.out.println("* x " + s.length());},
                s -> { return s.length() > 4;});
    }

}
