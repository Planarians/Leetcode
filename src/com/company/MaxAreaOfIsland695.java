package com.company;

/**
 * @program: Leetcode
 * @description: 33min
 * @author: Mr.Wang
 * @create: 2024-03-05 12:17
 **/
public class MaxAreaOfIsland695 {
    static class Solution {
        public static int maxAreaOfIsland(int[][] grid) {
            int rowSize=grid.length;
            int colSize=grid[0].length;
            int max=0;
            for(int r=0;r<rowSize;r++){
                for(int c=0;c<colSize;c++){
                    if(grid[r][c]==1){
                        max=Math.max(dfs(r,c,grid),max);
                        // System.out.println(count);
                    }
                }
            }
            return max;
        }

        public static int dfs(int r,int c,int[][] grid){
            int rowSize=grid.length;
            int colSize=grid[0].length;
            int size=0;
            int k1,k2,k3,k4=0;
            if(r<=rowSize-1&&r>=0&&c<=colSize-1&&c>=0&&grid[r][c]==1){
                grid[r][c]=0;
                size=1;
                // System.out.println("r: "+r+" c: "+c);
                k1=dfs(r+1,c,grid);
                k2=dfs(r,c+1,grid);
                k3=dfs(r-1,c,grid);
                k4=dfs(r,c-1,grid);
                return size+k1+k2+k3+k4;
            }
            return 0;

        }
    }

    /**
     1 1 0 0 0
     1 1 0 0 0
     0 0 0 1 1
     0 0 0 1 1

     **/





    public static void main(String[] args) {
        int[][] gid={{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}};
        System.out.println(Solution.maxAreaOfIsland(gid));
    }

/**
 1 1 0 1 1
 1 0 0 0 0
 0 0 0 0 1
 1 1 0 1 1

 **/




}
