package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2023-12-17 17:16
 **/
public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {
        String Prefix = "";
        String shortestString = "";
        int k=0;

        shortestString = strs[0];
        for (String str : strs) {
            if(str.length()<shortestString.length()){
                shortestString=str;
            }
        }

        Prefix= shortestString;

        for (int j = 0; j <shortestString.length();j++){
            for (int i = 0; i < strs.length; i++) {
                if(strs[i].substring(0,Prefix.length()).contains(Prefix)){
                    k++;
                    if(k== strs.length){
                        return Prefix;
                    }
                }
                if(!strs[i].substring(0,Prefix.length()).contains(Prefix)){
                    Prefix=Prefix.substring(0,Prefix.length()-1);
                    k=0;
                }
            }
        }


        return Prefix;
    }


//    public static String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) {
//            return "";
//        }
//
//        String curPrefix = strs[0];
//        for (int i = 1; i < strs.length; i++) {
//            while (strs[i].indexOf(curPrefix) != 0) {
//                curPrefix = curPrefix.substring(0, curPrefix.length() - 1);
//                if (curPrefix.isEmpty()) {
//                    return "";
//                }
//            }
//        }
//        return curPrefix;
//    }


    public static void main(String[] args) {
//        ArrayList<String> test = new ArrayList<>(Arrays.asList("flower", "flow", "flight"));
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
