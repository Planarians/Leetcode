package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-25 17:26
 **/
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        String cs = "";
        String maxs = "";
        if (s.length() == 1) {
            return s;
        }

        // s.length() is odd
        for (int m = 0; m < s.length(); m++) {
            for (int r = m + 1; r < s.length(); r++) {
                if (2 * m - r < 0) {
                    break;
                }

                if (s.charAt(2 * m - r)==s.charAt(r)) {
                    cs = s.substring(2 * m - r, r + 1);
                    if (cs.length() > maxs.length()) {
                        maxs = cs;
                    }
                } else {
                    break;
                }

            }
        }

        // s.length() is even
        for (int mleft = 0; mleft < s.length(); mleft++) {
            for (int r = mleft + 1; r < s.length(); r++) {
                if (1-r+2*mleft < 0) {
                    break;
                }

                if (s.charAt(1-r+2*mleft)==s.charAt(r)) {
                    cs = s.substring(1-r+2*mleft, r + 1);
                    if (cs.length() > maxs.length()) {
                        maxs = cs;
                    }
                } else {
                    break;
                }

            }
        }

        if(s.length()>0&&maxs.length()==0){
            return String.valueOf(s.charAt(0));
        }
        return maxs;
    }



    public static void main(String[] args) {

        System.out.println(longestPalindrome("abb"));
    }
}
