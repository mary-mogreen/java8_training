package ch06.ex10;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mary-mogreen.
 */
public class AllLinks {
    public static void main(String[] args) throws InterruptedException {
        URL url;
        try {
            if (args.length == 1)
                url = new URL(args[0]);
            else
                url = new URL("https://en.wikipedia.org/wiki/Wikipedia");
            System.out.println(url.toString());
            CompletableFuture.supplyAsync(() -> blockingReadPage(url))
                    .thenApply(AllLinks::getLinks)
                    .thenAccept((links) -> {
                        links.parallelStream().forEach(System.out::println);
                    });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ForkJoinPool.commonPool().awaitTermination(10, TimeUnit.SECONDS);

    }

    private static String blockingReadPage(URL url) {
        StringBuilder builder = new StringBuilder();
        try (Scanner scanner = new Scanner(url.openStream())) {
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine()).append("\n");
            }
            return builder.toString();
        } catch (IOException e) {
            System.err.println(e);
        }
        return "";
    }

    private static List<String> getLinks(String contents) {
        Pattern pattern = Pattern.compile("<a\\s+href=\"(.*?)\".*?>(.*?)</a>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(contents);
        List<String> links = new ArrayList<>();
        while (matcher.find()) {
            links.add(matcher.group(1));
        }
        return links;
    }
}
