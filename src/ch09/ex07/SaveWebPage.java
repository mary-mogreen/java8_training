package ch09.ex07;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by mary-mogreen.
 */

/**
 * args[0]: open url
 * args[1]: save file
 */
public class SaveWebPage {
    public static void main(String[] args) throws IOException {
        try(InputStream in = new URL(args[0]).openStream()) {
            Files.copy(in, Paths.get(args[1]));
        }
    }
}
