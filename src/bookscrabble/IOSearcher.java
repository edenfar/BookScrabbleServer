package bookscrabble;

import java.io.File;
import java.util.Scanner;

public class IOSearcher implements FileSearcher {

    boolean stopMe;

    public IOSearcher() {
        stopMe = false;
    }

    @Override
    public boolean search(String word, String... fileNames) {
        try {
            for (String fileName: fileNames) {
                if (!stopMe)
                    break;
                Scanner s = new Scanner(new File(fileName));
                while (s.hasNext() && !stopMe)
                    if (s.next().equals(word))
                        return true;
                s.close();
            }
        } catch (Exception ignored) {
        }

        return false;
    }

    @Override
    public void stop() {
        stopMe = true;
    }
}
