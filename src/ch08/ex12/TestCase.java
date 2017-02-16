package ch08.ex12;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by mary-mogreen.
 */
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(TestCases.class)
public @interface TestCase {
    String param();
    String expected();
}
