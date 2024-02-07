package com.company;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-07 12:10
 **/
public class NumberOfMatchingSubsequences792M {
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            HashMap<String, Boolean> map = new HashMap<>();
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                if (map.containsKey(words[i])) {
                    if (map.get(words[i])) {
                        res++;
                    }
                } else {
                    if (isSubsequence(words[i], s)) {
                        res++;
                        map.put(words[i], true);
                    } else {
                        map.put(words[i], false);
                    }
                }
            }
            return res;
        }

        public boolean isSubsequence(String word, String s) {
            int k = 0;
            if (word.length() > s.length()) {
                return false;
            }
            for (int i = 0; i < word.length(); i++) {
                k = s.indexOf(word.charAt(i));
                if (k == -1) {
                    return false;
                } else {
                    s = s.substring(k + 1);
                }
            }
            return true;
        }
    }
}
