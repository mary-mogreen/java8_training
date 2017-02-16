package ch08.ex11;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Scanner;

/**
 * Created by mary-mogreen.
 */
public class GetPasswordProtectedContents {
    public static void main(String[] args) throws MalformedURLException {
        if (args.length == 1 && args[0].equals("sample")) {
            getContents(new URL("http://htaccess.cman.jp/sample_go/basic"), "guest", "password");
        } else {
            URL url;
            String username;
            String password;
            try {
                url = new URL(System.console().readLine("URL: "));
            } catch (MalformedURLException e) {
                System.err.println(e);
                return;
            }
            username = System.console().readLine("username: ");
            password = String.valueOf(System.console().readPassword("password: "));
            getContents(url, username, password);
        }
    }

    private static boolean getContents(URL url, String username, String password) {
        URLConnection connection;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            System.err.println(e);
            return false;
        }

        String up = username + ":" + password;
        String encoded = Base64.getEncoder().encodeToString(up.getBytes(Charset.forName("UTF-8")));
        connection.setRequestProperty("Authorization", "Basic " + encoded);
        try {
            connection.connect();
        } catch (IOException e) {
            System.err.println(e);
            return false;
        }

        try {
            InputStream in = connection.getInputStream();
            Scanner scanner = new Scanner(in);

            while(scanner.hasNextLine())
                System.out.println(scanner.nextLine());
            return true;
        } catch (IOException e) {
            System.err.println(e);
            return false;
        }
    }
}
