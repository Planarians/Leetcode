package com.company;

import java.util.ArrayList;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-21 15:19
 **/
public class SumRootToLeafNumbers129M {
    public static class TreeNode {
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

    public static int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, root.val, list);
        for (Integer n : list) {
            sum += n;
        }
        return sum;
    }

    public static void dfs(TreeNode root, int val, ArrayList<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                dfs(root.left, val * 10 + root.left.val, list);
            }
            if (root.right != null) {
                dfs(root.right, val * 10 + root.right.val, list);
            }
            if(root.left==null&&root.right==null){
                list.add(val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode left=new TreeNode(2);
        TreeNode right=new TreeNode(3);
        TreeNode node =new TreeNode(1,left,right);
        System.out.println(sumNumbers(node));
    }
}
