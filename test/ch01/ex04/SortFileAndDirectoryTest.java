package ch01.ex04;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created by mary-mogreen.
 */
public class SortFileAndDirectoryTest {

    @Test
    public void testSort() {
        File[] files = {
                new File("./test/testDir/dir1/dir1.txt"),
                new File("./test/ch01/ex04/SortFileAndDirectory.java"),
                new File("./test/ch01/ex02"),
                new File("./test"),
                new File("./test/testDir/test.md")
        };

        String[] expected = {
                "./test",
                "./test/ch01/ex02",
                "./test/ch01/ex04/SortFileAndDirectory.java",
                "./test/testDir/dir1/dir1.txt",
                "./test/testDir/test.md"
        };

        File[] result = SortFileAndDirectory.sort(files);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getPath());
            assertEquals(expected[i], result[i].getPath());
        }

    }

    @Test(expected = NullPointerException.class)
    public void testSort_null() {
        SortFileAndDirectory.sort(null);
    }
}
