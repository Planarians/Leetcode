package com.company;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-08 16:49
 **/

class Solution {
    public int removeDuplicates(int[] nums) {
        int output = 0;
        int k=0;
        Arrays.sort(nums);
        TreeSet<Integer> numsTreeSet = new TreeSet<>();
        for (int j : nums) {
            numsTreeSet.add(j);
        }
        for (Integer num : numsTreeSet) {
            nums[k++]=num;
        }
        output = numsTreeSet.size();

        return output;
    }
}

public class RemoveDuplicatesFromSortedArray26 {

}
