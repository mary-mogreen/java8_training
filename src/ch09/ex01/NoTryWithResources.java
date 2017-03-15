package ch09.ex01;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by mary-mogreen.
 */
public class NoTryWithResources {
    public static void main(String[] args) throws IOException {
        Scanner in;
        PrintWriter out;

        // Scannerのコンストラクタは例外をスローする
        try {
            in = new Scanner(Paths.get("./test/ch02/ex01/alice.txt"));
        } catch (IOException e) {
            System.out.println("scanner constructor: " + e);
            throw e;
        }

        // PrintWriterのコンストラクタは例外をスルー
        try {
            out = new PrintWriter("./alice_out.txt");
        } catch (FileNotFoundException e) {
            System.out.println("printer writer constructor: " + e);
            // in.close()は例外をスローする？
            in.close();
            throw e;
        }

        // hasNext(), next(), println()は例外をスローする
        try {
            while (in.hasNext())
                out.println(in.next().toLowerCase());
        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println("scanner hasNext/next or print writer println: " + e);
            throw e;
        } finally {
            // in.close()は例外をスローする？
            in.close();
            // out.close()は例外をスローする？
            out.close();
        }
    }
}
