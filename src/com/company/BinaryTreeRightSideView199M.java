package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-25 23:58
 **/
public class BinaryTreeRightSideView199M {

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


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        dfs(root, res, 1);
        return res;

    }

    public static void dfs(TreeNode root, List<Integer> res, int level) {
        if (root != null) {
            if (res.size() < level) {
                res.add(root.val);
            }
            dfs(root.right, res, level + 1);
            dfs(root.left, res, level + 1);
        }
    }
}

