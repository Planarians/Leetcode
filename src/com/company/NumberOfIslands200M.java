package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-29 21:10
 **/
public class NumberOfIslands200M {


    public int numIslands(char[][] grid) {
            int output = 0;
            int r = grid.length;
            int c = grid[0].length;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (grid[i][j] == '1') {
                        output++;
                        bfs(i, j, grid);
                    }
                }
            }
            return output;
        }

        public void bfs(int r, int c, char[][] grid) {
            if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1') {
                grid[r][c] = '0';
                bfs(r - 1, c, grid);
                bfs(r, c - 1, grid);
                bfs(r + 1, c, grid);
                bfs(r, c + 1, grid);
            } else {
                return;
            }
        }


}
