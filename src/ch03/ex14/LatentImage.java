package ch03.ex14;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.function.UnaryOperator;

/**
 * Created by mary-mogreen.
 */
public class LatentImage extends LatentPixelReader {
    private PixelReader reader;
    private ColorTransformer ct;
    private int width;
    private int height;
    private Color[][] cached;

    public LatentImage(Image image) {
        reader = image.getPixelReader();
        width = (int) image.getWidth();
        height = (int) image.getHeight();
        cached = new Color[width][height];
        ct = (x, y, r) -> r.getColor(x, y);
    }

    public LatentImage(PixelReader reader, int width, int height, ColorTransformer ct) {
        this.reader = reader;
        this.width = width;
        this.height = height;
        this.ct = ct;
        cached = new Color[width][height];
    }


    LatentImage transform(ColorTransformer f) {
        return new LatentImage(this, width, height, f);
    }

    LatentImage transform(UnaryOperator<Color> f) {
        return new LatentImage(this, width, height,
                (x, y, reader) -> f.apply(reader.getColor(x, y)));
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
        if (cached[x][y] == null)
            cached[x][y] = ct.apply(x, y, reader);
        return cached[x][y];
    }


}
