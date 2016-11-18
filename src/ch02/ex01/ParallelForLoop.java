package ch02.ex01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mary-mogreen.
 */
public class ParallelForLoop {
    private int count = 0;
    private int segment;
    private int wordLength;

    public ParallelForLoop(int segment, int wordLength){
        this.segment = segment;
        this.wordLength = wordLength;
    }

    public int count(List<String> words) {
        count = 0;
        List<WordCounter> threads = new ArrayList<>();
        // System.out.println("words.size: " + words.size());

        for (int i = 0; i < words.size(); i = i + segment) {
            // System.out.println("begin: " + i + ", end: " + (i + segment) );
            List<String> subWords = words.subList(i, (i + segment > words.size() ? words.size() - 1 : i + segment));
            threads.add(new WordCounter(subWords));
        }

        threads.forEach(Thread::start);


        for (WordCounter th: threads) {
            try {
                th.join();
                count += th.count;
                System.out.println(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }

        return count;

    }

    class WordCounter extends Thread {
        private final List<String> words;
        private int count;

        WordCounter(List<String> words) {
            this.words = new ArrayList<>(words);
        }

        @Override
        public void run() {
            words.forEach(w -> {
                if (w.length() > wordLength) count++;
            });
        }
    }
}
