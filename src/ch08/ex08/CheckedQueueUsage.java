package ch08.ex08;

import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mary-mogreen.
 */
public class CheckedQueueUsage {
    public static Queue<Path> pathQueue() {
        return new LinkedList<>();
    }
    public static Queue nonCheckedQueue() {
        return new LinkedList();
    }
    public static Queue checkedQueue() {
        return Collections.checkedQueue(new LinkedList<Path>(), Path.class);
    }
}
