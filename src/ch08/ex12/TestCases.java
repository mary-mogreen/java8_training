package ch08.ex12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by mary-mogreen.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TestCases {
    TestCase[] value();
}
