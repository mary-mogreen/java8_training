package ch08.ex08;

import org.junit.Test;

import java.nio.file.Path;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * Created by mary-mogreen.
 */
public class CheckedQueueUsageTest {
    @Test
    public void testPathQueue() throws Exception {
        // CheckedQueueUsage.pathQueue().add("string");
    }

    @Test(expected = ClassCastException.class)
    public void nonCheckedQueue() throws Exception {
        Queue queue = CheckedQueueUsage.nonCheckedQueue();
        assertTrue(queue.add("string"));
        ((Path)(queue.peek())).getFileName();
    }

    @Test(expected = ClassCastException.class)
    public void checkedQueue() throws Exception {
        CheckedQueueUsage.checkedQueue().add("string");
    }

}