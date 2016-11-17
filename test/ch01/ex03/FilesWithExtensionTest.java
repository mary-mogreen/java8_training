package ch01.ex03;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mary-mogreen.
 */
public class FilesWithExtensionTest {

    @Test
    public void testListWithExtension() {
        String[] files = FilesWithExtension.listWithExtension(new File("./test/testDir"), "md");
        String[] expected = {"test.md", "test2.md"};

        assertTrue(files.length == expected.length);

        for (int i = 0; i < files.length; i++) {
            assertEquals(expected[i], files[i]);
        }

    }

    @Test(expected = NullPointerException.class)
    public void testListWithExtension_dirNull() {
        FilesWithExtension.listWithExtension(null, "md");
    }

    @Test
    public void testListWithExtension_extensionNull() {
        String[] files = FilesWithExtension.listWithExtension(new File("./test/testDir"), null);
        assertEquals(0, files.length);
    }
}
