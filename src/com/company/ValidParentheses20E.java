package com.company;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description: 49min
 * @author: Mr.Wang
 * @create: 2024-01-20 17:29
 **/
public class ValidParentheses20E {
    public static boolean isValid(String s) {
        LinkedList<Character> list = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && (list.size() > 0)) {
                if (map.get(s.charAt(i)) == list.getLast()) {
                    list.removeLast();
                }else{
                    list.add(s.charAt(i));
                }
            }else {
                list.add(s.charAt(i));
            }
        }
        if (list.size() > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "(])";
        System.out.println(isValid(s));
    }

}
