package com.company;

import java.awt.print.Pageable;
import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-27 22:55
 **/
public class FindFirstAndLastPositionOfElementInSortedArray34M {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums.length == 0) {
            return res;
        }
        res[0] = findFirst(nums, target);
        if (res[0] < 0) {
            res[0] = -1;
            return res;
        }
        res[1] = findLast(nums, target,res[0]);
        if (res[1] < 0) {
            res[1] = -1;
        }

        return res;
    }

    public static int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int mid = 0;
        if (nums[0] == target) {
            return 0;
        }
        if(nums.length==1){
            if(target!=nums[0]){
                return -1;
            }
        }
        while (l <= r) {
            mid = (l + r) / 2;
            System.out.println("l: "+l+" r: "+r+" mid: "+mid);
            if (nums[mid] > target) {
                r = mid - 1;
                continue;
            }
            if (nums[mid] == target) {
                if (nums[mid - 1] < target) {
                    return mid;
                } else {// nums[mid-1]=target
                    r = mid - 1;
                    continue;
                }
            }
            if (nums[mid] < target) {
                l = mid + 1;
                continue;
            }
        }
        if(mid==0){
            return -1;
        }
        return -mid;
    }

    public static int findLast(int[] nums, int target,int l) {
        int r = nums.length-1;
        int mid = 0;
        if (nums[nums.length-1] == target) {
            return nums.length-1;
        }

        while (l <= r) {
            mid = (l + r) / 2;
            System.out.println("l: "+l+" r: "+r+" mid: "+mid);
            if (nums[mid] > target) {
                r = mid - 1;
                continue;
            }
            if (nums[mid] == target) {
                if (nums[mid + 1] > target) {
                    return mid;
                } else {// nums[mid-1]=target
                    l = mid + 1;
                    continue;
                }
            }
            if (nums[mid] < target) {
                l = mid + 1;
                continue;
            }
        }
        if(mid==0){
            return -1;
        }
        return -mid;
    }


    public static void main(String[] args) {
        int[] nums={2,2};
        int target=2;

        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
}
