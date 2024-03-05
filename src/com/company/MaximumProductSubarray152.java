package com.company;

import java.util.ArrayList;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-04 20:37
 **/
public class MaximumProductSubarray152 {
   static class Solution3 {
        public static int maxProduct(int[] nums) {
            int size = nums.length;
            int max = 1;//without zero
            int min = 1;
            int res = nums[0];
            int temp=0;

            for (int i = 0; i < size; i++) {
                if (nums[i] == 0) {
                    max=1;
                    min=1;
                    res=Math.max(res, 0);
                } else {
                    temp=max*nums[i];
                    max = Math.max(nums[i], Math.max(min*nums[i], max*nums[i]));
                    min = Math.min(nums[i], Math.min(min*nums[i], temp));
                    // System.out.println("max "+max+" min: "+min);
                    res=Math.max(res, max);
                }
            }

            return res;
        }
    }
    static class Solution2 {//Time Limit Exceeded
        public static int maxProduct(int[] nums) {
            int size = nums.length;
            // int l=0;
            // int r=size-1;
            int max = nums[0];
            boolean f = false;
            int dp[] = new int[size];
            int res=0;
            // int product[][] = new int[size][size];
            ArrayList<Integer> zerolist = new ArrayList<>();
            dp[0] = nums[0];
            for (int i = 1; i < size; i++) {
                if (dp[i - 1] == 0) {
                    dp[i] = nums[i];
                    zerolist.add(i);
                } else {
                    dp[i] = dp[i - 1] * nums[i];
                }
                max = Math.max(nums[i], max);
                max = Math.max(max, dp[i]);
            }

            for (int r = 1; r < size; r++) {
                f = false;
                for (int l = 1; l <= r; l++) {
                    // System.out.println(l+" "+r);
                    for (int i = 0; i < zerolist.size(); i++) {
                        if (l <= zerolist.get(i) && zerolist.get(i) <= r) {
                            f = true;
                            break;
                        }
                    }
                    if (f) {
                        f = false;
                        continue;
                    }
                    if (dp[l - 1] == 0) {
                        res = dp[r];
                    } else {
                        res = dp[r] / dp[l - 1];
                    }
                    max = Math.max(max, res);
                }
            }
            return max;
        }
    }
    static class Solution {
        public static int maxProduct(int[] nums) {
            int size = nums.length;
            // int l=0;
            // int r=size-1;
            int max = nums[0];
            boolean f = false;
            int dp[] = new int[size];
            int product[][] = new int[size][size];
            ArrayList<Integer> zerolist = new ArrayList<>();
            dp[0] = nums[0];
            for (int i = 1; i < size; i++) {
                if (dp[i - 1] == 0) {
                    dp[i] = nums[i];
                    zerolist.add(i);
                } else {
                    dp[i] = dp[i - 1] * nums[i];
                }
                max = Math.max(nums[i], max);
                max = Math.max(max, dp[i]);
            }

            for (int r = 1; r < size; r++) {
                for (int l = 1; l < r; l++) {
                     System.out.println(l+" "+r);
                    for (int i = 0; i < zerolist.size(); i++) {
                        if (l <= zerolist.get(i) && zerolist.get(i) <= r) {
                            f = true;
                            break;
                        }
                    }
                    if (f) {
//                        System.out.println(l+" "+r);
                        f=false;
                        continue;
                    }
                    if (dp[l - 1] == 0) {
                        product[l][r] = dp[r];
                    } else {
                        product[l][r] = dp[r] / dp[l - 1];
                    }
                    max = Math.max(max, product[l][r]);
                }
            }
            return max;
        }

        /**
         * dp[0]=nums[0];
         * dp[1]=dp[0]*nums[1];
         * dp[2]=
         * dp[i]=Math.max(dp[i-1],)
         * <p>
         * <p>
         * product[l][r]=dp[r]/dp[l-1]
         * product[1][2]=dp[2]/dp[0]=-2/-1
         */
        public static void main(String[] args) {
            int[] nums = {1,0,-1,2,3,-5,-2};
            System.out.println(Solution.maxProduct(nums));

        }
    }
}
