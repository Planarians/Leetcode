package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-10 08:04
 **/
public class MergeSortedArray88E {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {
            nums1[i]=nums2[i-m];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {

    }
}
