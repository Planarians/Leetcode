package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-19 16:29
 **/
public class BestTimeToBuyAndSellStock121E {


    public int maxProfit(int[] prices) {
            int sum=0;
            int minPrice=Integer.MAX_VALUE;
            int curPrice=0;


            for(int i=0;i<prices.length;i++){
                curPrice=prices[i];
                minPrice=Math.min(minPrice,curPrice);
                sum=Math.max(sum,prices[i]-minPrice);

            }

            // for(int i=0;i<prices.length;i++){
            //     for(int j=i+1;j<prices.length;j++){
            //         sum=Math.max(sum,prices[j]-prices[i]);
            //     }
            // }
            return sum;
        }

}
