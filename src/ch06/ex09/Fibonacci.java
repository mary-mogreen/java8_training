package ch06.ex09;

import java.util.Arrays;

/**
 * Created by mary-mogreen.
 */
public class Fibonacci {
    private static final int n = 10;
    public static void main(String[] args) {
        F[] fibonacci = new F[n];
        Arrays.parallelSetAll(fibonacci, f -> new F());
        Arrays.parallelPrefix(fibonacci, Matrix::multiply);
        System.out.println("answer: " + fibonacci[n-1].f00);
    }

    static class Matrix {
        public static F multiply(F f1, F f2) {
            long f00 = f1.f00 * f2.f00 + f1.f01 * f2.f10;
            long f01 = f1.f00 * f2.f01 + f1.f01 * f2.f11;
            long f10 = f1.f10 * f2.f00 + f1.f11 * f2.f10;
            long f11 = f1.f10 * f2.f01 + f1.f11 * f2.f11;
            return new F(f00, f01, f10, f11);
        }
    }

    static class F {
        long f00;
        long f01;
        long f10;
        long f11;

        public F() {
            f00 = 1;
            f01 = 1;
            f10 = 1;
            f11 = 0;
        }

        public F(long f00, long f01, long f10, long f11) {
            this.f00 = f00;
            this.f01 = f01;
            this.f10 = f10;
            this.f11 = f11;
        }
    }
}
