package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-03 18:35
 **/
public class ValidPalindrome125 {
    public static boolean isPalindrome(String s) {
        String res="";
        for(int i=0;i<s.length();i++){
            if(('0'<=s.charAt(i)&&s.charAt(i)<='9')||('A'<=s.charAt(i)&&s.charAt(i)<='Z')||('a'<=s.charAt(i)&&s.charAt(i)<='z')){
                res+=String.valueOf(s.charAt(i)).toLowerCase();
            }
        }

        StringBuffer sb=new StringBuffer(res);
        if(res.equals(sb.reverse().toString())){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String s="race a car";
        System.out.println(isPalindrome(s));
    }
}
