package com.nick.algorithm.algorithm.lru;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 *
 * @author weizhong
 * @date 2020/3/28 4:15 PM
 * @package com.nick.algorithm.algorithm.lru
 * @description
 *
 */
public class LRUCache {

    private Map<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    /**
     *
     * @param capacity
     */
    public LRUCache(int capacity) {
        map = Maps.newHashMap();
        cache = new DoubleList();
        this.cap = capacity;
    }

    /**
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).value;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node x = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(x);
            map.remove(key);
        } else {
            if (cap == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(x);
        map.put(key, x);
    }

}
