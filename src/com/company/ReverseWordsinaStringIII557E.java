package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-04-14 23:20
 **/
public class ReverseWordsinaStringIII557E {
    class Solution {
        public String reverseWords(String s) {
            String res="";
            String [] strings=s.split("\\s+");
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<strings.length;i++){
                sb=new StringBuffer(strings[i]).reverse();
                if(i!=strings.length-1){
                    res=res+sb.toString()+" ";
                }else{
                    res=res+sb.toString();
                }
            }
            return res;
        }
    }
}
