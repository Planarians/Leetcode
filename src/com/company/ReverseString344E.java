package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-04-09 02:14
 **/
public class ReverseString344E {
    class Solution {
        public void reverseString(char[] s) {
            int size=s.length;
            char swap=' ';
            for(int i=0;i<size/2;i++){
                swap=s[size-i-1];
                s[size-i-1]=s[i];
                s[i]=swap;
                // System.out.print(size-i-1+" "+i+" "+" ");
                // System.out.println(s);
            }
        }
    }

//better change the name swap to temp
}
