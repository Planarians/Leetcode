package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-17 09:50
 **/
public class RepeatedSubstringPattern459E {
    public class Solution3 {
        public boolean repeatedSubstringPattern(String s) {
            String doubled = s + s;
            String sub = doubled.substring(1, doubled.length() - 1);
            return sub.contains(s);
        }
    }
    class Solution2 {
        public boolean repeatedSubstringPattern(String s) {
            String first="";
            String last="";
            if(s.length()==1){
                return false;
            }
            for(int i=0;i<s.length()/2;i++){
                first+=s.charAt(i);
                last=s.charAt(s.length()-1-i)+last;
                if(first.equals(last)){
                    if(s.replace(first,"").equals("")){
                        return true;
                    }
                }
            }
            return false;
        }
    }
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            String res="";
            if(s.length()==1){
                return false;
            }
            for(int i=0;i<s.length()/2;i++){
                res+=s.charAt(i);
                if(s.replace(res,"").equals("")){
                    return true;
                }
            }
            return false;
        }
    }
}
