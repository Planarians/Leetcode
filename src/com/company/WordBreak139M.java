package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-03 08:27
 **/
public class WordBreak139M {
    class Solution1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            int len=s.length();
            boolean [] dp=new boolean [len];
            String subStr="";

            //preprocessing
            HashSet<String> set=new HashSet<>();
            for(String str:wordDict){
                set.add(str);
            }
            for(int r=0;r<dp.length;r++){
                subStr+=s.charAt(r);
                if(set.contains(subStr)){
                    dp[r]=true;
                    continue;
                }
                for(int l=0;l<r;l++){
                    if(dp[l]==true&&set.contains(s.substring(l + 1, r + 1))) {
                        dp[r]=true;
                        break;
                    }
                }
            }

            return dp[len-1];
        }
    }
    static class Solution {//not right

        public static boolean wordBreak(String s, List<String> wordDict) {
            return dp(0, s, wordDict);
        }

        public static boolean dp(int k, String s, List<String> words) {
            boolean f = false;
            if (s.trim() != "") {
                for (int i = k; i < words.size(); i++) {
                    if (s.contains(words.get(i))) {
                        List<String> strs = getAllReplacedStrings(s, words.get(i), " ");
                        for (String str : strs) {
                            System.out.println(str);
                            if (dp(i + 1, str, words)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            } else {
                return true;
            }
        }

        public static List<String> getAllReplacedStrings(String original, String target, String replacement) {
            List<String> possibilities = new ArrayList<>();
            String strFirst = "";
            String strLeft = original;
//            while (!str.contains(target)){
//
//            }
            for (int i = 0; i < original.length(); i++) {
                strLeft = original.substring(i, original.length());
                if (strLeft.contains(target)) {
                    strLeft = strLeft.replaceFirst(target, replacement);
                    possibilities.add(strFirst + strLeft);
                }
                strFirst += original.charAt(i);
            }
            return possibilities;
        }


        public static void main(String[] args) {
            String s = "ccaccc";
            String[] strs = {"cc", "ac"};
            List<String> words = new ArrayList<>(Arrays.asList(strs));
//        Solution.wordBreak(s,words);
            System.out.println(Solution.getAllReplacedStrings("applepenapple", "apple", " "));
        }

/**
 39
 */
    }
}