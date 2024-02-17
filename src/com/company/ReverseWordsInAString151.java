package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-17 00:11
 **/
public class ReverseWordsInAString151 {
    public static String reverseWords(String s) {
        s=s.trim();
        String [] res =s.split("\\s+");
        String output="";
        for(int i=res.length-1;i>=0;i--){
            res[i]=res[i].trim();
            if(i==0){
                output+=res[i];
            }else{
                output+=res[i]+" ";
            }
        }
        return  output;

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
