package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-24 17:37
 **/
public class RotateImage48M {
    public static void rotate(int[][] matrix) {
        int topLeft = 0;
        int k=0;
        int l = 0, r = matrix[0].length-1;
        int t = 0, b = matrix.length-1;
        while (l < r) {
            for (int i = 0; i < r-l; i++) {
                t=l;
                b=r;
                topLeft = matrix[t][l+i];
                matrix[t][l+i]=matrix[b-i][l];
                matrix[b-i][l]=matrix[b][r-i];
                matrix[b][r-i]=matrix[t+i][r];
                matrix[t+i][r]=topLeft;
            }
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
//        int [][] matrix={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int [][] matrix= {{1,2,3},{4,5,6},{7,8,9}};

        for(int[] row:matrix){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        rotate(matrix);
//        for(int[] row:matrix){
//            System.out.println(Arrays.toString(row));
//        }
//        System.out.println(Arrays.deepToString(matrix));
    }
}
