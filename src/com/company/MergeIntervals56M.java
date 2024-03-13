package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-13 22:06
 **/
public class MergeIntervals56M {
    static class Solution {
        public static int[][] merge(int[][] intervals) {
            ArrayList<int[]> list=new ArrayList<>();
            Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
            int a[]=new int [2];
            a[0]=intervals[0][0];
            a[1]=intervals[0][1];
            list.add(a);
            for(int i=0;i<intervals.length;i++){
                if(a[0]<=intervals[i][0]&&a[1]>=intervals[i][0]){
                    a[1]=Math.max(a[1],intervals[i][1]);
                }else{
                    a=intervals[i];
                    list.add(a);
                }
            }
            return list.toArray(new int [list.size()][]);
        }
    }

    public static void main(String[] args) {
        int [][]intervals={{1,4},{0,4}};
        Solution.merge(intervals);
    }

/**
 intervals[0][0]=1
 0 1=3
 1 0 =2
 1 1=6

 */
}
