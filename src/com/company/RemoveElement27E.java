package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-10 08:17
 **/
public class RemoveElement27E {
    public static int removeElement(int[] nums, int val) {
        int output=0;
        int[] nums1=nums;
        int repeatedValCount=0;

        for (int i = 0,k=0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums1[k++]=nums[i];
            }else {
                repeatedValCount++;
            }
        }



        nums=Arrays.copyOf(nums1,nums1.length);
//        for (int i = 0; i < nums1.length; i++) {
//            nums[i]=nums1[i];
//        }



        return nums.length-repeatedValCount;
    }

    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        int val=3;
        System.out.println(removeElement(nums,val));
        System.out.println(Arrays.toString(nums));
    }
}
