package ch08.ex12;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mary-mogreen.
 */
public class TestRunner {
    public static void main(String[] args) {
        run(TestSamples.class.getName());
    }
    public static void run(String className) {
        Class<?> cls;
        try {
            cls = Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
            return;
        }

        Method[] methods = cls.getMethods();
        for (Method method: methods) {
            TestCases testCases = method.getAnnotation(TestCases.class);
            if (testCases == null)
                continue;

            for (TestCase tc: testCases.value()) {
                try {
                    long ans = (Long)method.invoke(null, Integer.valueOf(tc.param()));
                    if (ans == Long.valueOf(tc.expected())) {
                        System.out.println("test ok;");
                    } else {
                        System.out.println("test ng; expected: " + tc.expected() + ", actual: " + ans);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
