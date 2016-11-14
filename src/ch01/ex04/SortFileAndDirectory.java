package ch01.ex04;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by mary-mogreen.
 */
public class SortFileAndDirectory {

    public static File[] sort(File[] files) {
        Objects.requireNonNull(files, "array must not be null.");
        File[] result = files.clone();
        Arrays.sort(result, (File first, File second) -> {
            if (first.isDirectory() && !second.isDirectory())
                return -1;
            else if (!first.isDirectory() && second.isDirectory())
                return 1;
            return first.getPath().compareTo(second.getPath());
        });
        return result;
    }

}
