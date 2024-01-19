package com.company;

import java.util.HashMap;
import java.util.LinkedList;

class LRUCache {
    int capacity = 0;
    int evictKey = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    LinkedList<Integer> list = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove((Integer)key);
            list.addFirst(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if ((map.size() == capacity) && !map.containsKey(key)) {
            evictKey = list.removeLast();
            map.remove(evictKey);
        }
        if (map.containsKey(key)) {
            list.remove((Integer)key);
        }
        list.addFirst(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */