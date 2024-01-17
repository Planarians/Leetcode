package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-17 18:02
 **/
public class RemoveDuplicatesfromSortedArrayII80M {
    public static int removeDuplicates(int[] nums) {
        int output=0;
        ArrayList<Integer> list=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> set1=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                if(!set1.contains(nums[i])){
                    set1.add(nums[i]);
                    list.add(nums[i]);
                }
            }else{
                set.add(nums[i]);
                list.add(nums[i]);
            }
        }

        for(int i=0;i<list.size();i++){
            nums[i]=list.get(0);
        }

        return list.size();
    }

    public static void main(String[] args) {
        int nums[]={1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
