package ch01.ex02;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/**
 * Created by mary-mogreen.
 */
public class SubDirectoryTest {

    @Test
    public void testListSubDirectories() {

        File[] subDirectories = SubDirectory.listSubDirectories(new File("./test/testDir"));
        String[] expected = {"dir1", "dir2", "dir3"};

        for (int i = 0; i < subDirectories.length; i++) {
            if (!subDirectories[i].isDirectory())
                fail();
            else
                assertEquals(expected[i], subDirectories[i].getName());

        }
    }

    @Test(expected = NullPointerException.class)
    public  void testListSubDirectories_null() {
        SubDirectory.listSubDirectories(null);
    }

    @Test
    public void testListSubDirectories2() {

        File[] subDirectories = SubDirectory.listSubDirectories2(new File("./test/testDir"));
        String[] expected = {"dir1", "dir2", "dir3"};

        for (int i = 0; i < subDirectories.length; i++) {
            if (!subDirectories[i].isDirectory())
                fail();
            else
                assertEquals(expected[i], subDirectories[i].getName());

        }
    }

    @Test(expected = NullPointerException.class)
    public  void testListSubDirectories2_null() {
        SubDirectory.listSubDirectories2(null);
    }



}
