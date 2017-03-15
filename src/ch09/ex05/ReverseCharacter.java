package ch09.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by mary-mogreen.
 */

/**
 * args[0]: read file
 * args[1]: write file
 */
public class ReverseCharacter {
    public static void main(String[] args) throws IOException {
        byte[] ordered = Files.readAllBytes(Paths.get(args[0]));

        int length = ordered.length;
        byte[] reversed = new byte[length];
        for (int i = 0; i < length; i++) {
            reversed[length - 1 - i] = ordered[i];
        }

        Files.write(Paths.get(args[1]), reversed);

    }
}
