package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-25 12:31
 **/




public class BinaryTreeInorderTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(res, root);
        return res;
    }

    public static void dfs(List<Integer> res, TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                dfs(res, root.left);
            }
            res.add(root.val);
            if (root.right != null) {
                dfs(res, root.right);
            }
        }

    }
}


//先走到最左边然后逐级回溯 结束没执行完的代码
