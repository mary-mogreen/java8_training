package ch04.ex03;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import java.util.Objects;

/**
 * Created by mary-mogreen.
 */
public class XxxProperty<T> {
    private T value;
    private T defaultValue;
    private Property<T> property;


    public XxxProperty (T defaultValue) {
        Objects.requireNonNull(defaultValue, "default value is null.");
        this.defaultValue = defaultValue;
    }

    public void setValue(T value) {
        if (property == null) {
            if (defaultValue.equals(value))
                return;
            createProperty(value);
        } else
            property.setValue(value);
    }

    public T getValue() {
        if (property == null)
            return defaultValue;
        else
            return property.getValue();
    }

    public Property<T> xxxProperty() {
        if (property != null)
            return property;
        else {
            createProperty(getValue());
            return property;
        }

    }

    private void createProperty(T value) {
        property = new SimpleObjectProperty<>();
        property.setValue(value);
    }

    public static void main(String[] args) {

    }



}
