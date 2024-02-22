package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-22 23:35
 **/
public class CombinationSum39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> list=new ArrayList<>();
            List<Integer> path=new ArrayList<>();
            dfs(0,target,path,list,candidates);
            return list;
        }

        public void dfs(int j,int target,List<Integer> path,List<List<Integer>> list,int[] candidates){
            if(target==0){
                list.add(new ArrayList<>(path));
                return;
            }
            if(target<0){
                return;
            }
            for(int i=j;i<candidates.length;i++){
                path.add(candidates[i]);
                dfs(i,target-candidates[i],path,list,candidates);
                path.remove(Integer.valueOf(candidates[i]));
            }
        }
    }



/**

 dp7
 dp7-2 dp7-3 dp7-6 dp7-7

 */
}
