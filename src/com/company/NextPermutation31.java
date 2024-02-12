package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-11 01:11
 **/
public class NextPermutation31 {

    public static void nextPermutation(int[] nums) {
        int k = -1;
        int r = -1;
        int rValue=0;
        int temp=0;
        if (nums.length == 1) {
            return;
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                k = i;
                break;
            }
        }
        // if all desc
        if(k==-1){
            Arrays.sort(nums);
            return;
        }
        r = k;
        for (int j = k+1; j <= nums.length - 1; j++) {
            if (nums[j] > nums[k]) {
                if(r==k){
                    r = j;
                    rValue=nums[j];
                }
                if(nums[j]<rValue){
                    r=j;
                }
            }
        }

        //swap k r
        temp=nums[k];
        nums[k]=nums[r];
        nums[r]=temp;

        Arrays.sort(nums, k+1,nums.length);
        return;

    }

    public static void main(String[] args) {
        int [] nums={3,2,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}



/**

 15476
 15674

 k=4
 r=6

 651672

 */

