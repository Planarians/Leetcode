package com.company;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-29 19:06
 **/
public class SubarraySumEqualsK560M {

    public int subarraySum(int[] nums, int k) {
        int[] sub_sum= new int[nums.length];
        int cur_sum=0;
        int left=0;
        int output=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            left=(i>=1)?sub_sum[i-1]:0;
            sub_sum[i]=left+nums[i];
            if(map.containsKey(sub_sum[i]-k)){
                output+=map.get(sub_sum[i]-k);
            }
            map.put(sub_sum[i],map.getOrDefault(sub_sum[i],0)+1);
        }
        return output;
    }


    public int subarraySum0(int[] nums, int k) {
        int[] sub_sum = new int[nums.length];
        int cur_sum = 0;
        int left = 0;
        int output = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            left = (i >= 1) ? sub_sum[i - 1] : 0;
            sub_sum[i] = left + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                left = (i >= 1) ? sub_sum[i - 1] : 0;
                cur_sum = sub_sum[j] - left;
                if (cur_sum == k) {
                    output++;
                }
            }
        }
        return output;
    }

}
