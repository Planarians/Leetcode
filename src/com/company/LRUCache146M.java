package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-19 15:30
 **/
public class LRUCache146M {
    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // cache is {1=1}
//        lRUCache.put(2, 2); // cache is {1=1, 2=2}
//        System.out.println(lRUCache.get(1));
//        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//        System.out.println(lRUCache.get(2));
//        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//        System.out.println(lRUCache.get(1));
//        System.out.println(lRUCache.get(3));
//        System.out.println(lRUCache.get(4));
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2)); //-1
        lRUCache.put(2, 6); // cache is {2=6}
        System.out.println(lRUCache.get(1));//-1
        lRUCache.put(1, 5);// LRU key was 2, evicts key 1, cache is {2=6,1=5} real cache is {2=6,1=5}
        lRUCache.put(1, 2); // LRU key was 2, evicts key 1, cache is {2=6,1=2}
        System.out.println(lRUCache.get(1));//2
        System.out.println(lRUCache.get(2));//6
    }
}
