package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-29 01:28
 **/
public class SearchA2DMatrixII240M {
    static class Solution3 {
        public static boolean searchMatrix(int[][] matrix, int target) {
            int maxC=matrix[0].length-1;
            int maxR=matrix.length-1;
            int c=maxC;
            int r=0;
            while(c>=0&&r<=maxR){
                if(matrix[c][r]==target){
                    return true;
                }else if(matrix[c][r]>target){
                    c--;
                }else{
                    r++;
                }
            }
            return false;
        }
    }
    class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int rowMax = matrix.length - 1;
            int colMax = matrix[0].length - 1;
            int rowCur = 0;
            int colCur = colMax;

            while (rowCur <= rowMax && colCur >= 0) {
                if (matrix[rowCur][colCur] == target) {
                    return true;
                } else if (matrix[rowCur][colCur] > target) {
                    colCur--;
                } else {
                    rowCur++;
                }
            }

            return false;
        }
    }
    static class Solution {
        public static boolean searchMatrix(int[][] matrix, int target) {
            int l=0;
            int c=0;
            int r=0;
            c=findColoum(matrix,target);
            r=findRow(matrix,target);
            if(matrix[0][c]==target){
                return true;
            }
            if(matrix[r][0]==target){
                return true;
            }
            for(int i=0;i<=r;i++){
                if(binarySearch(i,c,matrix,target)){
                    return true;
                }
            }
            return false;
        }

        public static int findColoum(int[][] matrix, int target){
            int l=0;
            int r=matrix[0].length;
            int mid=0;
            while(l<=r){
                mid=(l+r)/2;
                System.out.println("l: "+l+" r: "+r+" mid: "+mid);
                if(mid+1==matrix[0].length){
                    return mid;
                }
                if(matrix[0][mid]==target){
                    return mid;
                }else if(matrix[0][mid]>target){
                    r=mid-1;
                }else{//<target
                    if(matrix[0][mid+1]>target){//what if mid+1>length-1
                        return mid;
                    }else{
                        l=mid+1;
                    }
                }
            }
            return mid;
        }
        public static int findRow(int[][] matrix, int target){
            int l=0;
            int r=matrix.length;
            int mid=0;
            while(l<=r){
                mid=(l+r)/2;
                System.out.println("l: "+l+" r: "+r+" mid: "+mid);
                if(mid+1==matrix.length){
                    return mid;
                }
                if(matrix[mid][0]==target){
                    return mid;
                }else if(matrix[mid][0]>target){
                    r=mid-1;
                }else{//<target
                    if(matrix[mid+1][0]>target){//what if mid+1>length-1
                        return mid;
                    }else{
                        l=mid+1;
                    }
                }
            }
            return mid;
        }

        public static boolean binarySearch(int row,int r,int[][] matrix, int target){
            boolean f=false;
            int l=0;
            int mid=0;
            while(l<=r){
                mid=(l+r)/2;
                if(matrix[row][mid]==target){
                    return true;
                }else if(matrix[row][mid]>target){
                    r=mid-1;
                }else{//<target
                    l=mid+1;
                }
            }
            return matrix[row][mid]==target;
        }

        public static void main(String[] args) {
            int[][] matrix={{1,1}};
            int target=2;
            System.out.println(Solution3.searchMatrix(matrix, target));
        }
    }

/**
 *
 * m[i][j]<m[i+1][j]
 * m[i][j]<m[i][j+1]
 */



}
