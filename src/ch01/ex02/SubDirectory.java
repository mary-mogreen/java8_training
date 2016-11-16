package ch01.ex02;

import com.sun.istack.internal.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mary-mogreen.
 */
public class SubDirectory {

    public static File[] listSubDirectories(@NotNull File directory) {
        File[] subDirectories = directory.listFiles(f -> {
            return f.isDirectory();
        });
        return subDirectories;
    }

    public static File[] listSubDirectories2(@NotNull File directory) {
        return directory.listFiles(File::isDirectory);
    }
}
