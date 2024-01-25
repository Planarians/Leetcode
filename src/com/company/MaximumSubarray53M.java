package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-25 11:29
 **/
public class MaximumSubarray53M {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum<0){
                sum=0;
            }
            sum+=nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int maxSubArray1(int[] nums) {
        int TempMax = nums[0];
        int FinalMax = nums[0];
        for (int i = 1; i < nums.length; i++){
            TempMax = Math.max((TempMax + nums[i]), nums[i]);
            FinalMax = Math.max(FinalMax, TempMax);
        }
        return FinalMax;
    }


//    public static int maxSubArray(int[] nums) {
//        int max=nums[0];
//        int sum=nums[0];
//        for(int i=0;i<nums.length;i++){
//            for(int j=i;j<nums.length;j++){
//                max=Math.max(max,sum(i,j,nums));
//            }
//        }
//        return max;
//    }
//    public static int sum(int l,int r,int[] nums){
//        if(l==r){
//            return nums[l];
//        }
//        else{
//            return sum(l,r-1,nums)+sum(r,r,nums);
//        }
//    }
}
