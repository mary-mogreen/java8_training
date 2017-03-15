package ch09.ex04;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mary-mogreen.
 */
public class MultipleExceptions {

    public static void main(String[] args) {
        try {
            Class.forName(MultipleExceptions.class.getName()).getMethod("main").invoke(null, new String[] {});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main2(String[] args) {
        try {
            Class.forName(MultipleExceptions.class.getName()).getMethod("main2").invoke(null, new String[] {});
        } catch (IllegalAccessException|InvocationTargetException|NoSuchMethodException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main3(String[] args) {
        try {
            Class.forName(MultipleExceptions.class.getName()).getMethod("main2").invoke(null, new String[] {});
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }
}
