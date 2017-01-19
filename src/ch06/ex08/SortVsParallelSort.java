package ch06.ex08;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by mary-mogreen.
 */
public class SortVsParallelSort {

    private static int[] testArray;
    private static int size;

    private static  long sortTime;
    private static long parallelSortTime;
    private static final int TIMES = 10;

    public static void main(String[] args) {
        size = 0;
        do {
            size += 10000;

            sortTime = 0;
            parallelSortTime = 0;

            testArray = array(size);

            for (int i = 0; i < TIMES; i++) {
                int[] arraySort = testArray.clone();
                Instant startSort = Instant.now();
                Arrays.sort(arraySort);
                Instant endSort = Instant.now();
                sortTime += Duration.between(startSort, endSort).getNano();

                int[] arrayParallelSort = testArray.clone();
                Instant startParallelSort = Instant.now();
                Arrays.parallelSort(arrayParallelSort);
                Instant endParallelSort = Instant.now();
                parallelSortTime += Duration.between(startParallelSort, endParallelSort).getNano();
            }

            sortTime /= TIMES;
            parallelSortTime /= TIMES;

            System.out.println("array[" + size + "] sort: " + sortTime + "ns, parallel sort: " + parallelSortTime + "ns.");
        } while(sortTime < parallelSortTime);

        System.out.println("end.");
    }

    private static int[] array(int size) {
        Random rnd = new Random(Instant.now().getEpochSecond());
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt();
        }
        return array.clone();
    }
}
