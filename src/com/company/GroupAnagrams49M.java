package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 48min
 * @author: Mr.Wang
 * @create: 2024-01-12 15:13
 **/
public class GroupAnagrams49M {
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> listList = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            //sort the String

            String sortString = getSortString(str);
            ArrayList<String> list = new ArrayList<>();

            if(map.containsKey(sortString)){
                list=map.get(sortString);
            }
            list.add(str);
            map.put(sortString, list);
        }

        map.forEach((key,value)-> listList.add(value));

        return listList;
    }

    private static String getSortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs).toString());
    }
}
