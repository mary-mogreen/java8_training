package ch01.ex03;

import java.io.File;
import java.util.Objects;

/**
 * Created by mary-mogreen.
 */
public class FilesWithExtension {

    /**
     * 指定されたディレクトリの下にある指定された拡張子を持つ，すべてのファイルを返す。
     * 拡張子が null の場合は，空の配列を返す。
     * @param directory nullでないディレクトリ
     * @param extension 拡張子
     * @return 指定されたディレクトリの下にある指定された拡張子を持つ，すべてのファイル
     */
    public static String[] listWithExtension(File directory, String extension) {
        Objects.requireNonNull(directory, "directory must not be null.");

        return directory.list(((dir, name) -> {
            return name.endsWith("." + extension);
        }));
    }
}
