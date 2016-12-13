package ch03.ex12;

import ch03.ex11.ColorTransformer;
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
    private List<ColorTransformer> pendingOperations;

    private LatentImage(Image image) {
        in = image;
        pendingOperations = new ArrayList<ColorTransformer>();
    }

    LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(ColorTransformer.toTransformer(f));
        return this;
    }

    LatentImage transform(ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    static LatentImage from(Image image) {
        return new LatentImage(image);
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();

        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (ColorTransformer f: pendingOperations)
                    c = f.apply(x, y, c);
                out.getPixelWriter().setColor(x, y, c);
            }
        return out;
    }
}
