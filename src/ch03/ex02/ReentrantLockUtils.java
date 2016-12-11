import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockUtils
 */
public class ReentrantLockUtils {
    public static void main(String[] args) {
        ReentrantLock myLock = new ReentrantLock();
        withLock(myLock, () -> {
            for (int i = 0; i < 10; i++)
                System.out.printf("%d %s", i, (i == 9 ? "\n": ""));
            System.out.printf("end"); 
        });
    }

    public static void withLock(ReentrantLock lock, Runnable runner) {
        lock.lock();
        try {
            runner.run();
        } finally {
            lock.unlock();
        }
    }
}