package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-08 23:38
 **/
public class PerfectSquares279M {
        public int numSquares(int n) {
            int [] dp=new int [n+1];
            Arrays.fill(dp,Integer.MAX_VALUE);
            if(n==1){
                return 1;
            }
            dp[0]=0;
            for(int i=1;i<=n;i++){
                for(int j=1;j*j<=i;j++){
                    dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                }
            }
            return dp[n];
        }
}
