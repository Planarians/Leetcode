package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-26 17:51
 **/
public class LowestCommonAncestorOfABinaryTree236 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);


        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }

        return root;

    }

}
