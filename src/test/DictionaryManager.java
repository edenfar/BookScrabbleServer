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
        String word = args[args.length - 1]; // Save the last arg in a variable
        for (int i = 0; i < args.length - 1; i++) { // Go over all the args except the last one
            String fn = args[i];
            Dictionary dic = new Dictionary(fn);
            this.dictionaryMap.put(fn, dic);
        }
        for (Dictionary value : dictionaryMap.values()) {
            if (value.query(word)){
                ret = true;
            }
        }
        return ret;
    }

    public boolean challenge(String... args) {
        Boolean ret = false;               
        String word = args[args.length - 1]; // Save the last arg in a variable
        for (int i = 0; i < args.length - 1; i++) { // Go over all the args except the last one
            String fn = args[i];
            Dictionary dic = new Dictionary(fn);
            this.dictionaryMap.put(fn, dic);
        }
        for (Dictionary dic : dictionaryMap.values()) {
            if (dic.challenge(word)){
                ret = true;
            }
        }
        System.out.println(ret);
        return ret;
    }

    public int getSize() {
        return this.dictionaryMap.size();
    }
}
