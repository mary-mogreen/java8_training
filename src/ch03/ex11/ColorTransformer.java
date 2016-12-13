package ch03.ex11;


import javafx.scene.paint.Color;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);

    static ColorTransformer compose(ColorTransformer ct1, ColorTransformer ct2) {
        return (x, y, c) -> ct2.apply(x, y, ct1.apply(x, y, c));
    }

    static ColorTransformer toTransformer(UnaryOperator<Color> uo) {
        return (x, y, c) -> uo.apply(c);
    }

    static ColorTransformer frameColorTransformer(int frameThickness, Color color, int imageWidth, int imageHeight) {
        return (x, y, c) -> {
            if (frameThickness < 0)
                throw new IllegalArgumentException("frame thickness: " + frameThickness);
            if (imageWidth <= 0)
                throw new IllegalArgumentException("image width: " + imageWidth);
            if (imageHeight <= 0)
                throw new IllegalArgumentException("image height: " + imageHeight);

            if (imageWidth <= frameThickness * 2
                    || imageHeight <= frameThickness * 2)
                throw new IllegalArgumentException("too thick.");

            if (x > frameThickness && x < imageWidth - frameThickness)
                if (y > frameThickness && y < imageHeight - frameThickness)
                    return c;
            return color;
        };
    }
}