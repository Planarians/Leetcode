package com.company;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-01 08:58
 **/
public class LongestConsecutiveSequence128M {
    class Solution2 {
        public int longestConsecutive(int[] nums) {
            int res = 0;
            int length = 0;
            int cur = 0;
            if (nums.length == 0) {
                return 0;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n);
            }
            for (int n : nums) {
                if (!set.contains(n - 1)) {
                    length = 1;
                    cur = n;
                    while (set.contains(cur + 1)) {
                        length++;
                        cur++;
                    }
                    res = Math.max(res, length);
                }
            }
            return res;
        }
    }
    class Solution {
        public int longestConsecutive(int[] nums) {
            int res=1;
            int max=1;
            if(nums.length==0){
                return 0;
            }
            Arrays.sort(nums);
            for(int i=1;i<nums.length;i++){
                if(nums[i]==nums[i-1]+1){
                    max++;
                    res=Math.max(res,max);
                }else if(nums[i]!=nums[i-1]){
                    max=1;
                }
            }
            return res;
        }
    }
}
