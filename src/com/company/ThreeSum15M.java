package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 51m
 * @author: Mr.Wang
 * @create: 2024-01-24 13:04
 **/
public class ThreeSum15M {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int l = 1;
        int r = nums.length - 1;

        for (int i = 0; i < nums.length - 2; i++) {
            l = i + 1;
            r = nums.length - 1;
            if (i >= 1) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
            }

            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    // if (!output.contains(list)) {
                    output.add(list);
                    // }
                    l++;
                    //l need to be different
                    while((nums[l-1]==nums[l])&&(l<r)){
                        l++;
                    }

                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                }

            }

        }

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());

    }

}
