package ch04.ex02;/**
 * Created by mary-mogreen.
 */

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

public class XxxProperty<T> {

    private T value;
    private Property<T> property;


    public void setValue(T value) {
        if (property == null)
            this.value = value;
        else
            property.setValue(value);
    }

    public T getValue() {
        if (property == null)
            return value;
        else
            return property.getValue();
    }

    public Property<T> xxxProperty() {
        if (property != null)
            return property;
        else {
            property = new SimpleObjectProperty<>();
            property.setValue(value);
            return property;
        }

    }

    public static void main(String[] args) {

    }



}
