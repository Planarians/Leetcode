package com.company;

import java.util.HashMap;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-26 19:22
 **/
public class OutOfBoundaryPaths576 {
    static HashMap<String, Long> map = new HashMap<>();

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        return (int)dfs(m, n, maxMove, startRow, startColumn);
    }

    public static long dfs(long m, long n, long maxMove, long startRow, long startColumn) {
        String key = maxMove + "," + startRow + "," + startColumn;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        long modulo = 1000000007;
        long result = 0;
        if (startRow <= -1 || startColumn <= -1 || startRow >= m || startColumn >= n) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
         result +=
           dfs(m, n, maxMove - 1, startRow - 1, startColumn)%modulo
         + dfs(m, n, maxMove - 1, startRow, startColumn - 1)%modulo
         + dfs(m, n, maxMove - 1, startRow + 1, startColumn)%modulo
         + dfs(m, n, maxMove - 1, startRow, startColumn + 1)%modulo;
         result=result%modulo;

        //  result += dfs(m, n, maxMove - 1, startRow - 1, startColumn);
        //     result %= modulo;
        //     result += dfs(m, n, maxMove - 1, startRow + 1, startColumn);
        //     result %= modulo;
        //     result += dfs(m, n, maxMove - 1, startRow, startColumn - 1);
        //     result %= modulo;
        //     result += dfs(m, n, maxMove - 1, startRow, startColumn + 1);
        //     result %= modulo;

        // result += dfs(m, n, maxMove - 1, startRow - 1, startColumn)%modulo;
        // result += dfs(m, n, maxMove - 1, startRow + 1, startColumn)%modulo;
        // result += dfs(m, n, maxMove - 1, startRow, startColumn - 1)%modulo;
        // result += dfs(m, n, maxMove - 1, startRow, startColumn + 1)%modulo;
        // result %= modulo;

        map.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findPaths(8,50,23,5,26));
        System.out.println(findPaths(1,3,3,0,1));
    }
}
