package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-25 23:44
 **/
public class BinaryTreeZigzagLevelOrderTraversal103M {

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


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, res, 0);
        return res;
    }

    public static void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root != null) {
            if (res.size() <= level) {
                res.add(new LinkedList());
            }
            if (level % 2 == 0) {
                res.get(level).add(root.val);
            } else {
                //res.get(level).addFirst(root.val);
            }
            if (root.left != null) {
                dfs(root.left, res, level + 1);
            }
            if (root.right != null) {
                dfs(root.right, res, level + 1);
            }
        }
    }
}

