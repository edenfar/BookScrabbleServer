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
        return false;
    }

    public boolean challenge(String... args) {
        return false;
    }

    public int getSize() {
        return this.dictionaryMap.size();
    }
}
