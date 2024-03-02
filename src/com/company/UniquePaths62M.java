package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-01 10:16
 **/
public class UniquePaths62M {

    class Solution1 {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];

            for (int j = n - 1; j >= 0; j--) {
                for (int i = m - 1; i >= 0; i--) {
                    if (i == m - 1 && j == n - 1) {
                        dp[m - 1][n - 1] = 1;
                    } else {
                        dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
                    }
                }
            }
            return dp[0][0];
        }
    }
    /**
     *
     * dp[i][j]=dp[i][j+1]+dp[i+1][j];
     *
     */
    class Solution {
        public int uniquePaths(int m, int n) {
             if(m==2){
                 return n;
             }
             if(n==2){
                 return m;
             }
            m--;
            n--;
            return (int)combinations(m + n, n);
        }

        public double combinations(double n, double k) {
            // Initialize result to 1
            double result = 1;

            // Calculate n! / (k! * (n - k)!)
            for (double i = 1; i <= k; i++) {
                result *= n--;  //n*n-1*...n-k
                result /= i;// /1*2*k
            }

            return result;
        }

    }

}
