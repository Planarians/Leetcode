package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-17 06:20
 **/
public class FirstMissingPositive124H {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            Arrays.sort(nums);
            int res=1;
            if(nums[nums.length-1]<=0){
                return 1;
            }
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=0){
                    continue;
                }
                if(i>=1){
                    if(nums[i]==nums[i-1]){
                        continue;
                    }
                }
                if(res<nums[i]){
                    return res;
                }else{
                    res++;
                }
            }
            return nums[nums.length-1]+1;
        }
    }
}
