package ch04.ex03;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by mary-mogreen.
 */
public class XxxPropertyTest {
    @Test
    public void testXxxProperty() {
        XxxProperty<String> stringProperty = new XxxProperty<>("test");
        assertTrue(stringProperty.getValue().equals("test"));
        stringProperty.xxxProperty();
        assertTrue(stringProperty.getValue().equals("test"));
        stringProperty.setValue("test2");
        assertTrue("test2".equals(stringProperty.xxxProperty().getValue()));
    }

    @Test
    public void tesSetValue() {
        XxxProperty<String> stringProperty = new XxxProperty<>("test");
        assertTrue(stringProperty.getValue().equals("test"));
        stringProperty.setValue("test2");
        assertTrue("test2".equals(stringProperty.xxxProperty().getValue()));
    }
}
