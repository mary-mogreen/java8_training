package ch01.ex08;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mary-mogreen.
 */
public class CaptureLoop {
    public static void main(String[] args) {
        String[] names = { "Peter", "Paul", "Mary" };

        enhancedForLoop(names).forEach(Runnable::run);

        System.out.println("");

        forLoop(names).forEach(Runnable::run);

    }

    public static List<Runnable> enhancedForLoop(String[] args) {
        List<Runnable> runners = new ArrayList<>();
        for (String name: args) {
            runners.add(() -> System.out.println(name));
        }
        return runners;
    }

    public static List<Runnable> forLoop(String[] names) {
        List<Runnable> runners = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            int finalI = i;
            runners.add(() -> System.out.println(names[finalI]));
        }
        return runners;
    }

    public static List<Runnable> forLoop2(String[] names) {
        List<Runnable> runners = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners.add(() -> System.out.println(name));
        }
        return runners;
    }
}
