package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-05 23:30
 **/
public class LongestIncreasingSubsequence300M {

    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        int maxLIS = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (LIS[i] == 0) {
                LIS[i] = 1;
            }
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[j] > nums[i]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }


        Arrays.sort(LIS);
        return LIS[LIS.length - 1];
    }
}

