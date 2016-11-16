package ch01.ex12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mary-mogreen.
 */
public class ListHasStream extends ArrayList {

//    public List stream() {
//        return this.subList(0, this.size());
//    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("String");
        list.add(1.0);
        list.add(100L);
        list.add(true);

        list.stream();
    }
}
