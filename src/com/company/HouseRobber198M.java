package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-08 23:43
 **/
public class HouseRobber198M {
    class Solution {
        public int rob(int[] nums) {
            int size = nums.length;
            int[] dp = new int[size];
            int max = 0;
            int res = 0;
            dp[size - 1] = nums[size - 1];
            max = dp[size - 1];
            for (int i = size - 2; i >= 0; i--) {
                if (i == size - 2) {
                    dp[i] = nums[size - 2];
                } else {
                    dp[i] = nums[i];
                    for (int j = i + 2; j < size; j++) {
                        res = Math.max(dp[j], res);
                    }
                    dp[i] += res;
                }
                // System.out.println("dp"+i+" ="+dp[i]);
                max = Math.max(max, dp[i]);
                res = 0;
            }
            return max;
        }
    }

/**
 * dp[4]=nums[4]
 * dp[3]=nums[3]
 * dp[2]=nums[2]+nums[4]=nums[2]+dp[4]
 * dp[1]=nums[1]+Math.max(dp[3],dp[4]);
 * dp[0]=
 *
 *
 */

}
