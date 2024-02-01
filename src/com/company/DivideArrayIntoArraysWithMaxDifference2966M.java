package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-01 18:00
 **/
public class DivideArrayIntoArraysWithMaxDifference2966M {

    public int[][] divideArray(int[] nums, int k) {
        int m = nums.length % 3;
        if (m > 0) {
            m = 1;
        }

        int[][] empty = {};

        int[][] res = new int[m + nums.length / 3][3];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            res[i / 3][i % 3] = nums[i];
            if (i % 3 - 1 > 0 && res[i / 3][i % 3] - res[i / 3][i % 3 - 1] > k) {
                // return null;
                // return new int[][]{};
                return empty;
            }
            if (i % 3 == 2 && res[i / 3][i % 3] - res[i / 3][i % 3 - 2] > k) {
                return new int[][]{};
            }
        }
        return res;
    }


/**
 *
 * 0 1 2
 *
 * 3 4 5
 * 0 1 2
 *
 *
 * 7/3=2
 *
 *
 */

}
