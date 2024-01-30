package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description: 23min
 * @author: Mr.Wang
 * @create: 2024-01-30 10:35
 **/
public class SpiralMatrix54M {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        String right = "right";
        String left = "left";
        String up = "up";
        String down = "down";
        dfs(matrix, list, 0, 0, right);
        return list;
    }

    public void dfs(int[][] matrix, List<Integer> list, int i, int j, String towards) {
        String right = "right";
        String left = "left";
        String up = "up";
        String down = "down";
        if (matrix[i][j] == 101) {
            return;
        }
        if (towards.equals("right")) {
            list.add(matrix[i][j]);
            matrix[i][j] = 101;
            if (j + 1 < matrix[0].length && matrix[i][j + 1] != 101) {
                dfs(matrix, list, i, j + 1, right);
            } else if (i + 1 < matrix.length && matrix[i + 1][j] != 101) {
                dfs(matrix, list, i + 1, j, down);
            } else {
                return;
            }
        }
        if (towards.equals("down")) {
            list.add(matrix[i][j]);
            matrix[i][j] = 101;
            if (i + 1 < matrix.length && matrix[i + 1][j] != 101) {
                dfs(matrix, list, i + 1, j, down);
            } else if (j - 1 >= 0 && matrix[i][j - 1] != 101) {
                dfs(matrix, list, i, j - 1, left);
            } else {
                return;
            }
        }
        if (towards.equals("left")) {
            list.add(matrix[i][j]);
            matrix[i][j] = 101;
            if (j - 1 >= 0 && matrix[i][j - 1] != 101) {
                dfs(matrix, list, i, j - 1, left);
            } else if (i - 1 >= 0 && matrix[i - 1][j] != 101) {
                dfs(matrix, list, i - 1, j, up);
            } else {
                return;
            }
        }
        if (towards.equals("up")) {
            list.add(matrix[i][j]);
            matrix[i][j] = 101;
            if (i - 1 >= 0 && matrix[i - 1][j] != 101) {
                dfs(matrix, list, i - 1, j, up);
            } else if (j + 1 < matrix[0].length && matrix[i][j + 1] != 101) {
                dfs(matrix, list, i, j + 1, right);
            } else {
                return;
            }
        }
    }


}
