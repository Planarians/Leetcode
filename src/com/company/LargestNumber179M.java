package com.company;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-02 15:17
 **/
public class LargestNumber179M {
    static class Solution {
        public static String largestNumber(int[] nums) {
            String res = "";
            boolean ifAllZero=true;
            String[] strings = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if(nums[i]!=0){
                    ifAllZero=false;
                }
            }
            if(ifAllZero){
                return "0";
            }
            for (int i = 0; i < nums.length; i++) {
                strings[i] = nums[i] + "";
            }
//            Arrays.sort(strings,new Comparator<String>(){
//                public int compare(String a,String b){
//                    return (b+a).compareTo(a+b);
//                }
//            });
            Arrays.sort(strings,(a,b)->(b+a).compareTo(a+b));
            for (String s : strings) {
                res += s;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int [] nums={3,30,34,5,9};
        Solution.largestNumber(nums);
    }
}
