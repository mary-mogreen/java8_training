package ch01.ex07;

/**
 * Created by mary-mogreen.
 */
public class RunnableAndThen {

    /**
     * ２つの Runnable インスタンスを受け取り，
     * 最初の Runnable を実行した後に２つ目の Runnable を実行する Runnable を返す。
     * @param first　最初に実行する Runnable
     * @param second 次に実行する Runnable
     * @return first, second の順に実行する Runnable インスタンス
     */
    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }
}
