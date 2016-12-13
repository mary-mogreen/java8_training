package ch03.ex14;

import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.paint.Color;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Created by mary-mogreen.
 */
public class LatentPixelReader implements PixelReader {
    @Override
    public PixelFormat getPixelFormat() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getArgb(int x, int y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Color getColor(int x, int y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T extends Buffer> void getPixels(int x, int y, int w, int h, WritablePixelFormat<T> pixelformat, T buffer, int scanlineStride) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getPixels(int x, int y, int w, int h, WritablePixelFormat<ByteBuffer> pixelformat, byte[] buffer, int offset, int scanlineStride) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getPixels(int x, int y, int w, int h, WritablePixelFormat<IntBuffer> pixelformat, int[] buffer, int offset, int scanlineStride) {
        throw new UnsupportedOperationException();
    }
}
