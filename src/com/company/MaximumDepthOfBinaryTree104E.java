package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-02 12:59
 **/
public class MaximumDepthOfBinaryTree104E {


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


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 1);
    }

    public int dfs(TreeNode root, int depth) {
        int leftDepth = depth;
        int rightDepth = depth;
        if (root != null) {

            if (root.left != null) {
                leftDepth = dfs(root.left, depth + 1);
            }

            if (root.right != null) {
                rightDepth = dfs(root.right, depth + 1);
            }
        }
        depth = Math.max(leftDepth, rightDepth);
        return depth;
    }


/**
 (3,1)

 l=1 l=(9,2)
 l=2

 r=1 r=(20,2)



 */
}
