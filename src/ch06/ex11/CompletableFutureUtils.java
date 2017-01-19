package ch06.ex11;

import java.net.PasswordAuthentication;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.Thread.*;

/**
 * Created by mary-mogreen.
 */
public class CompletableFutureUtils {
    public static <T> CompletableFuture<T> repeat (
            Supplier<T> action, Predicate<T> until) {
        return CompletableFuture.supplyAsync(action)
        .thenComposeAsync(t -> {
            if (until.test(t))
                return CompletableFuture.completedFuture(t);
            return repeat(action, until);
        });
    }

    public static void main(String[] args) {
        CompletableFuture<PasswordAuthentication> pa = repeat(() -> {
            Scanner in = new Scanner(System.in);
            System.out.print("username: ");
            String userName = in.nextLine();

            System.out.print("password: ");
            String pw = in.nextLine();
            return new PasswordAuthentication(userName, pw.toCharArray());
        }, t -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            return String.valueOf(t.getPassword()).equals("secret");
        });
        try {
            System.out.println("success!! user: " + pa.get().getUserName() + ", password: " + String.valueOf(pa.get().getPassword()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
