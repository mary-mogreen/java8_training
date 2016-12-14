package ch04.ex05;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableObjectValue;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;

import java.util.Observable;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by mary-mogreen.
 */
public class ObservableValueUtils {

    public static <T, R> ObservableValue<R> observe(Function<T, R> f, ObservableValue<T> t) {
        return new ObservableValueBaseEx<>(f, t);
    }

    private static class ObservableValueBaseEx<T, R> extends ObservableValueBase<R> {
        private final Function<T, R> f;
        private final ObservableValue<T> t;

        ObservableValueBaseEx(Function<T, R> f, ObservableValue<T> t) {
            this.f = f;
            this.t = t;
            t.addListener(observable -> fireValueChangedEvent());
            t.addListener((observable, oldValue, newValue) -> fireValueChangedEvent());
        }
        @Override
        public R getValue() {
            return f.apply(t.getValue());
        }
    }

    public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
        return new BiObservableValueBaseEx<>(f, t, u);
    }

    private static class BiObservableValueBaseEx<T, U, R> extends ObservableValueBase<R> {
        private final BiFunction<T, U, R> f;
        private final ObservableValue<T> t;
        private final ObservableValue<U> u;

        BiObservableValueBaseEx(BiFunction<T, U, R> f, ObservableValue<T> t, ObservableValue<U> u) {
            this.f = f;
            this.t = t;
            this.u = u;
            t.addListener(observable -> fireValueChangedEvent());
            u.addListener(observable -> fireValueChangedEvent());
            t.addListener((observable, oldValue, newValue) -> fireValueChangedEvent());
            u.addListener((observable, oldValue, newValue) -> fireValueChangedEvent());
        }
        @Override
        public R getValue() {
            return f.apply(t.getValue(), u.getValue());
        }
    }
}
