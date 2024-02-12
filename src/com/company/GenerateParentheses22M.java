package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-11 22:36
 **/
public class GenerateParentheses22M {

        public static List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            String s = "";
            dfs(n, n, s, list);
            return list;
        }

    public static void dfs(int left, int right, String s, List<String> list) {
        if (left == right && left == 0) {
            list.add(s);
        } else {
            if (left < right && right - 1 >= 0) {
//                s+=")";
//                dfs(left, right - 1, s,list);     wrong need to create a new string because strings are immutable in Java. Concatenating strings using += in a recursive function can lead to incorrect results.
                dfs(left, right - 1, s+")",list);
            }
            if (left - 1 >= 0) {
                dfs(left - 1, right,s+"(", list);
            }
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3);
    }




/**
 * (((())))
 *
 *
 */
}
