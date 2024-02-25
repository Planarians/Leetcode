package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-25 15:04
 **/
public class MaximalSquare221M {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int m=matrix[0].length;
            int n=matrix.length;
            int res=0;
            int right;
            int down;
            int rightDown;
            int[][] dp=new int[n][m];
            for(int i=n-1;i>=0;i--){
                for(int j=m-1;j>=0;j--){
                    if(matrix[i][j]!='0'){
                        if(i==n-1||j==m-1){
                            dp[i][j]=1;
                        }else{
                            right=dp[i][j+1];
                            down=dp[i+1][j];
                            rightDown=dp[i+1][j+1];
                            if(right==0||down==0||rightDown==0){
                                dp[i][j]=1;
                            }else{
                                dp[i][j]=1+Math.min(Math.min(right,down),rightDown);
                            }
                        }

                        res=Math.max(res,dp[i][j]);
                    }
                }
            }
            return res*res;
        }


    }
}
