package com.company;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2023-12-14 19:16
 **/
public class PalindormeNumber9 {
    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder(s);
//        StringBuilder reverseSb = sb.reverse();
        if(sb.toString().equals(sb.reverse().toString())){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = -1;
        while(sc.hasNext()){

            if(isPalindrome(sc.nextInt())){
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }



    }
}










