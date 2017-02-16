package ch08.ex09;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by mary-mogreen.
 */
public class ScannerUtils {


    /**
     * 単語のストリームへ変換
     * @param scanner
     * @return
     */
    public static Stream<String> toWordStream(Scanner scanner) {
        Iterator<String> iter = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return scanner.hasNext();
            }

            @Override
            public String next() {
                return scanner.next();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    /**
     * 行のストリームへ変換
     * @param scanner
     * @return
     */
    public static Stream<String> toLineStream(Scanner scanner) {
        Iterator<String> iter = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return scanner.hasNextLine();
            }

            @Override
            public String next() {
                return scanner.nextLine();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    /**
     * 整数のストリームへ変換
     * @param scanner
     * @return
     */
    public static Stream<Integer> toIntegerStream(Scanner scanner) {
        Iterator<Integer> iter = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return scanner.hasNextInt();
            }

            @Override
            public Integer next() {
                return scanner.nextInt();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    /**
     * 整数のストリームへ変換
     * @param scanner
     * @return
     */
    public static Stream<Double> toDoubleStream(Scanner scanner) {
        Iterator<Double> iter = new Iterator<Double>() {
            @Override
            public boolean hasNext() {
                return scanner.hasNextDouble();
            }

            @Override
            public Double next() {
                return scanner.nextDouble();
            }
        };
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }

    /**
     * BufferedReader#lines
     * @return
     */
//    public Stream<String> lines() {
//        Iterator<String> iter = new Iterator<String>() {
//            String nextLine = null;
//
//            @Override
//            public boolean hasNext() {
//                if (nextLine != null) {
//                    return true;
//                } else {
//                    try {
//                        nextLine = readLine();
//                        return (nextLine != null);
//                    } catch (IOException e) {
//                        throw new UncheckedIOException(e);
//                    }
//                }
//            }
//
//            @Override
//            public String next() {
//                if (nextLine != null || hasNext()) {
//                    String line = nextLine;
//                    nextLine = null;
//                    return line;
//                } else {
//                    throw new NoSuchElementException();
//                }
//            }
//        };
//        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(
//                iter, Spliterator.ORDERED | Spliterator.NONNULL), false);
//    }
}
