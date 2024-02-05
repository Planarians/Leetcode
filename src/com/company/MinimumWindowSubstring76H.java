package com.company;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-04 23:42
 **/
public class MinimumWindowSubstring76H {

    public static String minWindow(String s, String t) {
        String res = "";
        String cur = "";
        int have = 0;
        int need = 0;
        int l = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> wMap = new HashMap<>();
        if (t.length() > s.length()) {
            return "";
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }

        need = map.size();

        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                if (wMap.containsKey(s.charAt(r))) {
                    wMap.put(s.charAt(r), wMap.get(s.charAt(r)) + 1);
                } else {
                    wMap.put(s.charAt(r), 1);
                }
                if (wMap.get(s.charAt(r)).equals(map.get(s.charAt(r)))) {
                    have++;
                }
            }

            while (have == need && l <= r) {

                if (map.containsKey(s.charAt(l))) {
                    cur = s.substring(l, r + 1);
                    if(res.equals("")){
                        res=cur;
                    }
                    res = (res.length() > cur.length() ? cur : res);

                    if (wMap.get(s.charAt(l)).equals(map.get(s.charAt(l)))) {
                        wMap.put(s.charAt(l), wMap.get(s.charAt(l)) - 1);
                        if (wMap.get(s.charAt(l)) == 0) {
                            wMap.remove(s.charAt(l));
                        }
                        have--;
                    } else {
                        wMap.put(s.charAt(l), wMap.get(s.charAt(l)) - 1);
                        if (wMap.get(s.charAt(l)) == 0) {
                            wMap.remove(s.charAt(l));
                        }
                    }
                }
                l++;
            }

        }

        return res;

    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));

    }

}
