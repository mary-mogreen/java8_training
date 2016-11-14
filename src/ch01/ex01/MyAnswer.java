package ch01.ex01;


import java.util.Arrays;
import java.util.Comparator;

public class MyAnswer {
    static boolean isThreadCallingSort;
    static Thread threadCallingSort;


    public static void main(String[] args) {
        String[] strings = {"a",  "1", "A"};
        threadCallingSort = Thread.currentThread();
        Arrays.sort(strings, new ComparatorTest());
        System.out.println("ソートを呼んだスレッドで実行される：　" + isThreadCallingSort);
        // Arrays.sortを呼んでいるスレッドで実行される。
    }

    static class ComparatorTest implements Comparator<String> {

        @Override
        public int compare(String first, String second) {
            if (Thread.currentThread().equals(threadCallingSort))
                isThreadCallingSort = true;
            return Integer.compare(first.length(), second.length());
        }
    }
}
