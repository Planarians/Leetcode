package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-22 00:39
 **/
public class FirstMissingPositive41H {
    static class Solution2 {
        public static int firstMissingPositive(int[] nums) {
            int temp = 0;
            int size = nums.length;
            int a=0;
            int b=0;
            for (int i = 0; i < size; i++) {
                if (nums[i] <= 0 || nums[i] > size) {
                    nums[i] = 0;
                } else {
                    a=nums[i];
                    if(a - 1 < size && a - 1 >= 0){
                        b=nums[a-1];
                        if (a!=b) {
                            if(a>=b){
                                swap(i, nums[i] - 1, nums);//1->0 i->i-1 swap(nums[i], nums[nums[i] - 1])
                            }else{
                                swap(i, nums[i] - 1, nums);
                            }
                            swap(nums[i] - 1,i,nums);
                        }
                    }

                }
            }

             System.out.println(Arrays.toString(nums));
            for (int i = 0; i < size; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return 0;
        }

        public static void swap(int a, int b, int[] nums) {
            int temp = 0;
//            if (nums[b] <= 0 || nums[b] > nums.length) {
//                nums[b] = 0;
//            }
            temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }

    }

    class Solution {//nlogn

        public int firstMissingPositive(int[] nums) {
            Arrays.sort(nums);
            int res = 1;
            if (nums[nums.length - 1] <= 0) {
                return 1;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0) {
                    continue;
                }
                if (i >= 1) {
                    if (nums[i] == nums[i - 1]) {
                        continue;
                    }
                }
                if (res < nums[i]) {
                    return res;
                } else {
                    res++;
                }
            }
            return nums[nums.length - 1] + 1;
        }
    }

    public static void main(String[] args) {
        int [] nums ={3,4,-1,1};
        Solution2.firstMissingPositive(nums);
    }
}
