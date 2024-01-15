package com.company;

import com.sun.jdi.IntegerValue;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-13 17:06
 **/
public class MinimumSizeSubarraySum209M {

    public static int minSubArrayLen0(int target, int[] nums) {
        int output = 0;
        int max = 0;
        int l = 0;
        int r = 0;
        boolean k = false;
        int[] outputs = new int[nums.length];


        for (int i = 0; i < nums.length; i++) {
            max += nums[i];
        }
        if (max < target) {
            return 0;
        } else if (max == target) {
            return nums.length;
        }


//        for (int i = 0; i < outputs.length; i++) {
//            outputs[i]=-1;
//        }
        Arrays.fill(outputs, -1);


        for (int i = 0; i < nums.length; i++) {
            max = 0;
            if (k) {
                break;
            }
            for (int j = i; j < nums.length; j++) {
                if ((max + nums[j] < target) && (j == nums.length - 1)) {
                    k = true;
                }
                if (max + nums[j] >= target) {
                    outputs[i] = j - i + 1;
                    r = j;
                    break;
                }
                max += nums[j];
            }
        }

        Arrays.sort(outputs);
        for (int j : outputs) {
            if (j != -1) {
                return j;
            }
        }


        return 0;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int max = 0;
        int l = 0;
        int res = Integer.MAX_VALUE;

        for (int r = 0; r < nums.length; r++) {
            max += nums[r];
            while (max >= target) {
                res = Math.min(res, r - l + 1);
                max -= nums[l];
                l++;
            }
        }

        return (res == Integer.MAX_VALUE)?0:res;

    }

    public static void main(String[] args) {
        int[] nums = {12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12};
        int target = 213;
        System.out.println(minSubArrayLen(target, nums));
    }

}
// first find subarray start from nums[0] then star from nums[1]

//2 3 1 2 4 3
//stars form 2 2+3+1+2=8
//stars form 3   3+1+2 or 3+1 can't be bigger than 2+3+1+2
//
//l=0   r=3
//if l move r have to move

//https://www.youtube.com/watch?v=aYqYMIqZx5s