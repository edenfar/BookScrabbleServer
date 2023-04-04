package bookscrabble;

public interface FileSearcher {
    boolean search(String word, String... fileNames);

    void stop();
}
