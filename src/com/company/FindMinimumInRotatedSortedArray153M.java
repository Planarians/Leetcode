package com.company;

/**
 * @program: Leetcode
 * @description: 48 min
 * @author: Mr.Wang
 * @create: 2024-03-09 13:37
 **/
public class FindMinimumInRotatedSortedArray153M {
   static class Solution {
        public static int findMin(int[] nums) {
            int l=0;
            int r=nums.length-1;
            int mid=0;
            if(nums.length==1){
                return nums[0];
            }

            //mid is in right part
            while(l<=r){
                mid=(l+r)/2;
                // System.out.println("l="+l+" r="+r+" mid="+mid);
                if(nums[mid]<=nums[l]&&nums[mid]<nums[r]){//mid in right part
                    if(mid-1==-1){
                        return nums[mid];
                    }
                    if(nums[mid]<nums[mid-1]&&nums[mid]<nums[mid+1]){//mid = min
                        return nums[mid];
                    }else{
                        r=mid-1;
                    }
                }else if(nums[mid]>nums[l]&&nums[mid]>nums[r]){//mid in left part
                    l=mid+1;
                }else if(nums[mid]>nums[l]&&nums[mid]<nums[r]){//mid l r in one part in right part
                    return nums[l];
                }else{//mid>r mid<l  ??? not possible //2，1 l=0 r=1 mid=0
                    return nums[r];
                }
            }
            return nums[mid];
        }
    }


    /**

     7 0 1 2 3 4 5 6


     */

    public static void main(String[] args) {
        int [] nums={3,4,5,1,2};
        Solution.findMin(nums);
    }


/**

 7 0 1 2 3 4 5 6


 */
}
