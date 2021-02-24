package labuladong;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruThroughMap {
    int cap;
    Map<Integer, Integer> lruMap;

    public LruThroughMap(int cap) {
        this.cap = cap;
        lruMap = new LinkedHashMap<>(cap);
    }

    public static void main(String[] args) {
        LruThroughMap cache = new LruThroughMap(5);

        for (int i = 0; i < 5; i++) {
            cache.put(i, i);
        }


        for (int i = 0; i < 5; i++) {
            cache.put(i, i);
        }
    }

    public Integer get(int key) {
        Integer value = lruMap.get(key);
        if (value != null) {
            lruMap.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        lruMap.remove(key);
        lruMap.put(key, value);

        if (lruMap.size() > cap) {
            Integer next = lruMap.keySet().iterator().next();
            lruMap.remove(next);
        }
    }
}
