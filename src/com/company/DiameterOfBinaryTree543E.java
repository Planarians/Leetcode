package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-18 00:33
 **/
public class DiameterOfBinaryTree543E {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[1]; // Array to hold max value
        dfs(root, max); // Call DFS with max array
        return max[0];
    }

    public int dfs(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left, max);
        int right = dfs(node.right, max);

        max[0] = Math.max(max[0], left + right); // Update max

        return Math.max(left, right) + 1;
    }

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

    int max = 0;

    public int diameterOfBinaryTree0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    public int dfs(TreeNode node) {
        int left = 0;
        int right = 0;
        if (node != null) {
            if (node.left != null) {
                left = 1 + dfs(node.left);
            }
            if (node.right != null) {
                right = 1 + dfs(node.right);
            }
            max = Math.max(left + right, max);
            return Math.max(left, right);
        }
        return 0;
    }
}
