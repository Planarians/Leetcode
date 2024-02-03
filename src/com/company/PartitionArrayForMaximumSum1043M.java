package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-03 22:32
 **/
public class PartitionArrayForMaximumSum1043M {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int max = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            max = 0;
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], (i - j >= 0 ? dp[i - j] : 0) + max * j);
            }
        }
        return dp[arr.length - 1];
    }


//The dp array is used to store the maximum sum for each subarray ending at index i.

/**
 dp[0]=1 arr[0-j+1]
 dp[1]=30 arr[1-j+1]


 */

}
