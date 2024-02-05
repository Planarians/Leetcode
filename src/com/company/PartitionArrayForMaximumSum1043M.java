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

 其实就是遍历每个数计算从头到i这个位置的最大值
    怎么计算呢 就是从这个位置再往左遍历k个位置把所有值都变成当前k个位置的最大值试试 然后再max取最大的就是当前的最大值
            很暴力的递归
 然后i-j+1就是此时

 dp[0]=1 arr[0-j+1]
 dp[1]=30 arr[1-j+1]


 */

}
