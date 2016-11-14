package ch01.ex11;

/**
 * Created by mary-mogreen.
 */
public interface I2 {
    default void f() {
        System.out.println("I2.f");
    }
}
