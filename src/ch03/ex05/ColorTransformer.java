package ch03.ex05;


import javafx.scene.paint.*;

@FunctionalInterface
public interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);
}