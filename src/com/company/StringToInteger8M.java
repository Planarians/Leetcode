package com.company;

import java.math.BigInteger;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-11 02:23
 **/
public class StringToInteger8M {


        public static int myAtoi1(String s) {
//            s = s.strip();  java11
            s=s.trim();
            if (s.isEmpty()){
                return 0;
            }

            final int sign = s.charAt(0) == '-' ? -1 : 1;
            if (s.charAt(0) == '+' || s.charAt(0) == '-'){
                s = s.substring(1);
            }

            long num = 0;

            for (final char c : s.toCharArray()) {
                if (!Character.isDigit(c)){
                    break;
                }
                num = num * 10 + (c - '0');
                if (sign * num <= Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                if (sign * num >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
            }

            return sign * (int) num;
        }


        public static int myAtoi(String s) {
            boolean pos=true;

            if(s.equals("")){
                return 0;
            }

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==' '){
                    if(i+1<s.length()){
                        s=s.substring(i+1);
                        i--;
                    }else{
                        s="";
                        return 0;
                    }
                }else{
                    break;
                }
            }

            if(s.charAt(0)=='+'){
                pos=true;
                s=s.substring(1);
            }else if(s.charAt(0)=='-'){
                pos=false;
                s=s.substring(1);
            }

            // if('0'>s.charAt(0)||s.charAt(0)>'9'){
            //     return 0;
            // }

            for(int i=0;i<s.length();i++){
                if('0'<=s.charAt(i)&&s.charAt(i)<='9'){

                }else{
                    s=s.substring(0,i);
                }
            }

            if(s.equals("")){
                return 0;
            }

            if(!pos){
                s="-"+s;
            }

            BigInteger bi=new BigInteger(s);
            if(bi.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>0){
                return Integer.MAX_VALUE;
            }

            if(bi.compareTo(BigInteger.valueOf(Integer.MIN_VALUE))<0){
                return Integer.MIN_VALUE;
            }

            return bi.intValue();


        }

    public static void main(String[] args) {
        String s="  0000000000012345678";
        System.out.println(myAtoi(s));
    }
}
