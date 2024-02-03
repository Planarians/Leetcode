package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-02 16:56
 **/
public class PathSum112E {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null && targetSum != 0) {
            return false;
        }
        return dfs(root, targetSum, 0);

    }

    public boolean dfs(TreeNode node, int target, int sum) {
        boolean left = false;
        boolean right = false;
        if (node != null) {
            if (sum + node.val == target && node.left == null && node.right == null) {
                return true;
            }
            if (node.left != null) {
                left = dfs(node.left, target, sum + node.val);
            }
            if (node.right != null) {
                right = dfs(node.right, target, sum + node.val);
            }
            if (left || right) {
                return true;
            }
        }
        return false;
    }
}
