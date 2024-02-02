package com.company;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-02 16:22
 **/
public class MajorityElement169E {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();

        if(nums.length==1){return nums[0];}
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                if(map.get(nums[i])>nums.length/2){
                    return nums[i];
                }
            }else{
                map.put(nums[i],1);
            }
        }
        return -1;

    }
}
