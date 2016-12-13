package ch03.ex15;

import ch02.ex01.ParallelForLoop;
import ch03.ex11.ColorTransformer;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

/**
 * Created by mary-mogreen.
 */
public class ParallelLatentImage {
    private Image in;
    private List<ColorTransformer> pendingOperations;

    private ParallelLatentImage(Image image) {
        in = image;
        pendingOperations = new ArrayList<ColorTransformer>();
    }

    ParallelLatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(ColorTransformer.toTransformer(f));
        return this;
    }

    ParallelLatentImage transform(ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    static ParallelLatentImage from(Image image) {
        return new ParallelLatentImage(image);
    }

    public Image toImage() {
        int n = Runtime.getRuntime().availableProcessors();
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        Color[][] colors = new Color[height][width];
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                colors[y][x] = in.getPixelReader().getColor(x, y);
        Color[][] pxl = new Color[height][width];
        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            for (int i = 0; i < n; i++) {
                int fromY = i * height / n;
                int toY = (i + 1) * height / n;
                pool.submit(() -> {
                    for (int x = 0; x < width; x++)
                        for (int y = fromY; y < toY; y++) {
                            Color c = colors[y][x];
                            for (ColorTransformer f : pendingOperations)
                                c = f.apply(x, y, c);
                            pxl[y][x] = c;
                        }
                });
            }
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y, pxl[y][x]);
            }
        return out;
    }
}
