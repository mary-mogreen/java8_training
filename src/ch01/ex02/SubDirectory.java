package ch01.ex02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by mary-mogreen.
 */
public class SubDirectory {

    public static File[] listSubDirectories(File directory) {
        Objects.requireNonNull(directory, "directory must not be null.");
        File[] subDirectories = directory.listFiles(f -> {
            return f.isDirectory();
        });
        return subDirectories;
    }

    public static File[] listSubDirectories2(File directory) {
        Objects.requireNonNull(directory, "directory must not be null.");
        return directory.listFiles(File::isDirectory);
    }
}
