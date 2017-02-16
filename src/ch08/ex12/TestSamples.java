package ch08.ex12;

/**
 * Created by mary-mogreen.
 */
public class TestSamples {
    @TestCase(param = "24", expected = "25")
    @TestCase(param = "-1", expected = "0")
    @TestCase(param = "0", expected = "-1")
    public static long plusOne(int n) {
        return n + 1L;
    }
}
