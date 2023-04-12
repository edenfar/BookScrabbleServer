package test;

import bookscrabble.Dictionary;

import java.util.HashMap;
import java.util.Map;

public class DictionaryManager {

    public Map<String, Dictionary> dictionaryMap;
    public static DictionaryManager manager;

    private DictionaryManager() {
        this.dictionaryMap = new HashMap<>();
    }

    public static DictionaryManager get() {
        if (manager == null)
            manager = new DictionaryManager();
        return manager;
    }

    public boolean query(String... args) {
        Boolean ret = false;               
        String word = args[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            String fn = args[i];
            Dictionary dictionary = new Dictionary(fn);
            this.dictionaryMap.put(fn, dictionary);
        }
        for (Dictionary value : dictionaryMap.values()) {
            if (value.query(word)){
                ret = true;
            }
            value.close();
        }
        return ret;
    }

    public boolean challenge(String... args) {
        Boolean ret = false;               
        String word = args[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            String fn = args[i];
            Dictionary dictionary = new Dictionary(fn);
            this.dictionaryMap.put(fn, dictionary);
        }
        for (Dictionary value : dictionaryMap.values()) {
            if (value.challenge(word)){
                ret = true;
            }
            value.close();
        }
        return ret;
    }

    public int getSize() {
        return this.dictionaryMap.size();
    }
}
