package ch01.ex10;

import java.util.Comparator;
import java.util.Random;

/**
 * Created by mary-mogreen.
 */
public interface List<E> {
    default <T> int binarySearch(T key) {throw new AssertionError();}

    default <T> int binarySearch(T key, Comparator<? super T> c) {throw new AssertionError();}

    default <T> int indexBinarySearch(T key) {throw new AssertionError();}

    default <T> int indexBinarySearch(T key, Comparator<? super T> c) {throw new AssertionError();}

    default <T> int iteratorBinarySearch(T key) {throw new AssertionError();}

    default <T> int iteratorBinarySearch(T key, Comparator<? super T> c) {throw new AssertionError();}

    default void reverse() {}

    default void shuffle() {}

    default void shuffle(Random rnd) {}

    default void swap(int i, int j) {}

    default <T> void fill(T obj) {}

    default <T> List<? super T> copy() {throw new AssertionError();}

    default void rotate(int distance) {}

    default <T> boolean replaceAll(T oldVal, T newVal) {throw new AssertionError();}

    default int indexOfSubList(List<?> target) {throw new AssertionError();}

    default int lastIndexOfSubList(List<?> target) {throw new AssertionError();}

    default <T> List<T> unmodifiableList() {throw new AssertionError();}

    default <T> List<T> synchronizedList() {throw new AssertionError();}

    default <T> List<T> synchronizedList(Object mutex) {throw new AssertionError();}

    default <E> List<E> checkedList(Class<E> type) {throw new AssertionError();}

    static <T> List<T> emptyList() {throw new AssertionError();}

    static <T> List<T> singletonList(T o) {throw new AssertionError();}

    static <T> List<T> nCopies(int n, T o) {throw new AssertionError();}
    
    // sort method は 引数なしはstatic? 引数ありは default?


}
