package ch03.ex14;


import ch03.ex13.LatentImage;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, PixelReader reader);
}