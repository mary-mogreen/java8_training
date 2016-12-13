package ch03.ex13;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Created by mary-mogreen.
 */
public class LatentImage {
    private Image in;
    private ColorTransformer ct;
    private int width;
    private int height;

    public LatentImage(Image image) {
        in = image;
        width = (int) in.getWidth();
        height = (int) in.getHeight();
    }

    public LatentImage(int width, int height) {
        in = null;
        this.width = width;
        this.height = height;
    }

    LatentImage transform(ColorTransformer f) {
        return new InnerLatentImage(this, f);
    }

    static LatentImage from(Image image) {
        return new LatentImage(image);
    }

    public Image toImage() {
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                Color c = getColor(x, y);
                out.getPixelWriter().setColor(x, y, c);
            }
        return out;
    }

    public Color getColor(int x, int y) {
        return in.getPixelReader().getColor(x, y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    class InnerLatentImage extends LatentImage {
        private LatentImage image;
        private ColorTransformer ct;
        InnerLatentImage(LatentImage image, ColorTransformer ct) {
            super(image.width, image.height);
            this.image = image;
            this.ct = ct;
        }
        public Color getColor(int x, int y) {
            return ct.apply(x, y, image);
        }
    }
}
