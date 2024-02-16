package com.company;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-14 05:47
 **/
public class CoinChange322 {
    public static int coinChange1(int[] coins, int amount) {
        int []dp=new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        if(amount==0){
            return 0;
        }
        for(int i=0;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0&&dp[i-coins[j]]!=-1){
                    if(dp[i]==-1){
                        dp[i]=1+dp[i-coins[j]];
                    }
                    dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        return dp[amount]==0?-1:dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int min=Integer.MAX_VALUE;
        min=dfs(0,0,amount,coins,map);
        if(min==Integer.MAX_VALUE){
            return -1;
        }else{
            return min;
        }
    }

    public int dfs(int sum,int num,int amount,int[] coins,HashMap<Integer,Integer> map){
        int min=Integer.MAX_VALUE;
        if(sum==amount){
            if(map.containsKey(amount)){
                map.put(amount,map.get(amount)>num?num:map.get(amount));
            }else{
                map.put(amount,num);
            }
            return num;
        }
        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                min= Math.min(min,dfs(coins[i],num+1,amount-coins[i],coins,map));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int [] coins={1,2,5};
        int amount=11;
        System.out.println(coinChange1(coins,11));
    }
}
