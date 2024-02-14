package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-13 01:58
 **/
public class Subsets78M {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        dfs(0,list,res,nums);
        return res;
    }

    public void dfs(int start,List<Integer> list,List<List<Integer>> res,int[] nums){
        res.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            dfs(i+1,list,res,nums);
            list.remove(list.size()-1);
        }
    }
}
