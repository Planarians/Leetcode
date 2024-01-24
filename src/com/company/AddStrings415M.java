package com.company;

/**
 * @program: Leetcode
 * @description: 38min
 * @author: Mr.Wang
 * @create: 2024-01-23 00:27
 **/
public class AddStrings415M {


    public String addStrings(String num1, String num2) {
        String output = "";
        int sum = 0;
        int addOne = 0;
        int size = Math.max(num1.length(), num2.length());
        int num1add = 0;
        int num2add = 0;

        for (int i = 0; i < size; i++) {
            if ((num1.length() - i - 1) >= 0) {
                num1add = num1.charAt(num1.length() - i - 1) - 48;
            } else {
                num1add = 0;
            }

            if ((num2.length() - i - 1) >= 0) {
                num2add = num2.charAt(num2.length() - i - 1) - 48;
            } else {
                num2add = 0;
            }

            sum = num1add + num2add + addOne;
            if (sum >= 10) {
                output = String.valueOf(sum - 10) + output;
                addOne = 1;
            } else {
                output = String.valueOf(sum) + output;
                addOne = 0;
            }
        }
        if (addOne == 1) {
            return "1" + output;
        }
        return output;
    }

}
