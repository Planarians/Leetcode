package com.company;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-14 19:31
 **/
public class LongestSubstringWithoutRepeatingCharacters3M {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int r = 0;
        int l = 0;
        while (r < s.length()) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1,l);
//                map.remove(s.charAt(r));
            }
            res=r-l+1;
            maxLength = Math.max(res, maxLength);
            map.put(s.charAt(r), r);
            r++;


        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
}


//a b c a b c b b
//r=0 l=0 set=a
//r=1 l=0 set=ab


//a b c a d c b e
//abc
//abca
//bcad
//bcadc
//adcbe

//for l to s.size
//if has repeat /if(map.contain(s.charAt(l)){l=m.get(l)+1}
//l=first repeat+1 for l to s.size


//a b c a d c b e
//abc map=abc l=0 r=3
//abca map=abc l=0 r=4 l=map.get(a)+1=0+1=1 r=5
//bcadc map=bcad l=1 r=6 l=map.get(c)+1=2+1=3 r=7
//bc..adcb map=abcd l=3 r=7 l=map.get(b)+1=2 r=8
//cadcbe


//l=0 r=0
//map=a res=1 r=1
//map=ab 2 2
//abc 3 3
//abca map=3 l=1 r=4
//bcad