package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-09 07:37
 **/
public class ContainerWithMostWater11H {
    public static int maxArea(int[] height) {
        int output = 0;
        int max = 0;
        int k = 0;
        int i=0;
        int j=height.length-1;

        if (height.length == 1) {
            return height[0];
        }
//        if (height.length == 2) {
//            return height[0];
//        }
//        for (int i = 0; i < height.length; i++) {
//            for (int j = height.length-1; i<j; j--) {
//                if(i==(j-1)){
//                    break;
//                }
//
//                k = Math.min(height[i], height[j]) * (j - i );
//
//                max = Math.max(max, k);
//
//            }
//        }
       while (i<j){
           if(height[i]<=height[j]){
               k = Math.min(height[i], height[j]) * (j - i);
               i++;
           }else {
               k = Math.min(height[i], height[j]) * (j - i);
               j--;
           }
            max = Math.max(max, k);

        }
        return max;
    }

    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(height.length);
        System.out.println(maxArea(height));
    }
}
//1 8