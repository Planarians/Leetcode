package com.company;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-07 11:34
 **/
public class SortCharactersByFrequency451 {

    public String frequencySort(String s) {
        String res = "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        ArrayList<Character> list = new ArrayList<>(map.keySet());
        //list.sort((a, b) -> {return map.get(b) - map.get(a);});
        list.sort((a, b) -> map.get(b) - map.get(a));
        for (char c : list) {
            for (int i = 0; i < map.get(c); i++) {
                res += String.valueOf(c);
            }
        }

        return res;
    }

}
