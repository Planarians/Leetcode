package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-25 15:30
 **/
public class PathSumII113M {

      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
      }
      }


    class Solution2 {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> list = new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) {
                return list;
            }
            dfs(root, 0, targetSum, list, res);
            return list;
        }

        public void dfs(TreeNode root, int cur, int target, List<List<Integer>> list, List<Integer> res) {
            if (root != null) {
                cur += root.val;
                res.add(root.val);
                if (cur == target && root.left == null && root.right == null) {
                    list.add(new ArrayList<>(res));
                    res.remove(res.size()-1);
                    return;
                } else {
                    dfs(root.left, cur, target, list, res);
                    dfs(root.right, cur, target, list, res);
                    res.remove(res.size()-1);
                }
            }

        }
    }

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> list = new ArrayList<>();
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) {
                return list;
            }
            dfs(root, 0, targetSum, list, res);
            return list;
        }

        public void dfs(TreeNode root, int cur, int target, List<List<Integer>> list, List<Integer> res) {
            if (root != null) {
                cur += root.val;
                res.add(root.val);
                if (cur == target && root.left == null && root.right == null) {
                    list.add(new ArrayList<>(res));
                    return;
                } else {
                    dfs(root.left, cur, target, list, new ArrayList<>(res));
                    dfs(root.right, cur, target, list, new ArrayList<>(res));
                }
            }

        }
    }

/**
 * 1
 * -2 -3
 * 1 3 -2
 * -1
 *
 *
 *
 */
}
