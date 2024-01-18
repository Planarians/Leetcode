package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description: 44min
 * @author: Mr.Wang
 * @create: 2024-01-18 14:33
 **/
public class IntegerToRoman12M {

    public static String intToRoman(int num) {
        String output = "";
        int k = num;
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");


        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (num >= entry.getKey()) {
                for (int i = 0; i < num / entry.getKey(); i++) {
                    output += entry.getValue();
                }
                num = num % entry.getKey();
            }
        }
        num = k;

        return output;


    }

}
