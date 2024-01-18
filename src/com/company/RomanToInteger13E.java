package com.company;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description: 21min
 * @author: Mr.Wang
 * @create: 2024-01-18 13:45
 **/
public class RomanToInteger13E {

        public int romanToInt(String s) {
            HashMap<Character,Integer> map=new HashMap<>();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);

            int output=map.get(s.charAt(s.length()-1));
            for(int i=0;i<s.length()-1;i++){
                if(map.get(s.charAt(i))>=map.get(s.charAt(i+1))){
                    output+=map.get(s.charAt(i));
                }else{
                    output-=map.get(s.charAt(i));
                }
            }
            return output;
        }

}
