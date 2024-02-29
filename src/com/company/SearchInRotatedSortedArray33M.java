package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-29 16:49
 **/
public class SearchInRotatedSortedArray33M {
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            int mid = 0;
            while (l <= r) {
                mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[mid] >= nums[l]) {// mid in left
                    if (target < nums[l] || target > nums[mid]) {// target in right
                        l = mid + 1;
                    } else {// target in left
                        r = mid - 1;
                    }
                } else {// mid in right
                    if (target > nums[r] || target < nums[mid]) {// target in left
                        r = mid - 1;
                        continue;
                    } else {// target in right
                        l = mid + 1;
                        continue;
                    }
                }
            }

            return -1;

        }
    }

    /*
     * -4 -3 -2 -1 0 1 2 3
     * 2 3
     *
     * max min
     * 4 5 6 7 0 1 2
     * l=7 p=3
     * num[l-1]=l-p
     * max.index+1=min.index
     *
     */
}
