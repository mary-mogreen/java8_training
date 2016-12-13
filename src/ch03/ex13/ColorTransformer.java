package ch03.ex13;


import javafx.scene.paint.Color;

import java.util.function.UnaryOperator;

@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, LatentImage image);

    static ColorTransformer blur() {
        return (x, y, image) -> {
            Color[] colors = getColors(x, y, image);

            double red, green, blue;
            red = green = blue = 0.0;
            int count = 0;
            for (Color c: colors) {
                if (c == null)
                    continue;
                count++;
                red += c.getRed();
                green += c.getGreen();
                blue += c.getBlue();
            }
            return Color.color(red / count, green / count, blue / count);
        };
    }

    static Color[] getColors(int x, int y, LatentImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        Color[] colors = new Color[9];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int pX = x + i - 1;
                int pY = y + j - 1;
                if (pX < 0 || pX >= width || pY < 0 || pY >= height)
                    colors[i * 3 + j] = null;
                else
                    colors[i * 3 + j] = image.getColor(pX, pY);
            }
        }
        return colors.clone();
    }

    static ColorTransformer edge() {
        return (x, y, image) -> {
            Color[] colors = getColors(x, y, image);

            int[] idx = {1, 3, 5, 7};
            double red, green, blue;
            red = green = blue = 0.0;
            int count = 0;
            for (int i: idx) {
                if (colors[i] == null)
                    continue;
                count++;
                red += colors[i].getRed();
                green += colors[i].getGreen();
                blue += colors[i].getBlue();
            }
            red = count * colors[4].getRed() - red;
            green = count * colors[4].getGreen() - green;
            blue = count * colors[4].getBlue() - blue;

            return Color.color(
                    red < 0.0 ? 0.0: red > 1.0 ? 1.0: red,
                    green < 0.0 ? 0.0: green > 1.0 ? 1.0: green,
                    blue < 0.0 ? 0.0: blue > 1.0 ? 1.0: blue);
        };
    }
}