package com.company;

import java.util.Scanner;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-08 17:35
 **/
public class ReverseInteger7 {

    public static int reverse(int x) {
        int output = 0;
        boolean ifNegative = false;
        String stringx = String.valueOf(x);
        StringBuilder stringBuilderX = new StringBuilder();

        if(stringx.equals("0")){
            return 0;
        }


        if (stringx.charAt(0) == '-') {
            ifNegative = true;
            stringx = stringx.replace("-", "");
        }


        stringBuilderX = new StringBuilder(stringx);
        stringx = stringBuilderX.reverse().toString();

        for (int i = 0; i < stringx.length(); i++) {
            if (stringx.charAt(i) == '0') {
                stringx = stringx.substring(i + 1);
                i--;
            } else {
                break;
            }
        }

        if (ifNegative) {
            stringx = "-" + stringx;
        }

       // System.out.println(Math.pow(2,-31));
        if(Long.parseLong(stringx)>Math.pow(2,31)-1||Long.parseLong(stringx)<Math.pow(-2,31)){
            return 0;
        }

        output = Integer.parseInt(stringx);

        return output;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            System.out.println(reverse(sc.nextInt()));
        }
    }
}
