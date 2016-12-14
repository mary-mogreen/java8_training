package ch04.ex02;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by mary-mogreen.
 */
public class XxxPropertyTest {
    @Test
    public void testXxxProperty() {
        XxxProperty<String> stringProperty = new XxxProperty<>();
        stringProperty.xxxProperty();
        assertTrue(stringProperty.getValue() == null);
        stringProperty.setValue("test");
        assertTrue("test".equals(stringProperty.xxxProperty().getValue()));
    }

    @Test
    public void tesSetValue() {
        XxxProperty<String> stringProperty = new XxxProperty<>();
        assertTrue(stringProperty.getValue() == null);
        stringProperty.setValue("test");
        assertTrue("test".equals(stringProperty.xxxProperty().getValue()));
    }
}
