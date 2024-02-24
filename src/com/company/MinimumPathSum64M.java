package com.company;

import java.util.Arrays;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-23 20:06
 **/
public class MinimumPathSum64M {
    class Solution {
        public int minPathSum1(int[][] grid) {
            int[][] res = new int[grid.length+1][grid[0].length+1];
            for(int[] row:res){
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            for (int i = grid.length - 1; i >= 0; i--) {
                for (int j = grid[0].length - 1; j >= 0; j--) {
                    if (i == grid.length - 1 && j == grid[0].length - 1) {
                        res[i][j] = grid[i][j];
                    } else {
                        res[i][j] = grid[i][j] + Math.min(res[i][j + 1], res[i + 1][j]);
                    }
                }
            }
            return res[0][0];
        }
        public int minPathSum(int[][] grid) {
            int[] min = { Integer.MAX_VALUE };
            dfs(0, 0, grid[0][0], min, grid);
            return min[0];

        }


        public void dfs(int i, int j, int sum, int[] min, int[][] grid) {
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                if (sum < min[0]) {
                    min[0] = sum;
                }
                return;

            }
            if (i < grid.length - 1) {
                dfs(i + 1, j, sum + grid[i + 1][j], min, grid);
            }
            if (j < grid[0].length - 1) {
                dfs(i, j + 1, sum + grid[i][j + 1], min, grid);
            }
        }
    }
}
