package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @program: Leetcode
 * @description: 20min
 * @author: Mr.Wang
 * @create: 2024-01-17 17:09
 **/
public class IsomorphicStrings205 {

    public boolean isIsomorphic(String s, String t) {
        boolean output = false;
        int k=0;
        int k1=0;
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> map1=new HashMap<>();
        if(s.length()!=t.length()){
            return output;
        }
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }
            list.add(map.get(s.charAt(i)));

            if(!map1.containsKey(t.charAt(i))){
                map1.put(t.charAt(i),i);
            }
            list1.add(map1.get(t.charAt(i)));

            if(!list.equals(list1)){
                return output;
            }
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        boolean output = false;
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> map1=new HashMap<>();
        if(s.length()!=t.length()){
            return output;
        }
        for(int i=0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
            }
            if(!map1.containsKey(t.charAt(i))){
                map1.put(t.charAt(i),i);
            }
            if(map.get(s.charAt(i))!=map1.get(t.charAt(i))){
                return false;
            }


        }
        return true;
    }
    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> list1=new ArrayList<>();



    }
}
