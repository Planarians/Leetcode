package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-20 00:03
 **/
public class SubtreeOfAnotherTree {


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

    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (ifSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean ifSameTree1(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot != null && root.val == subRoot.val) {
            return ifSameTree(root.left, subRoot.left) && ifSameTree(root.right, subRoot.right);
        }
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (subRoot != null && root == null) {
            return false;
        } // else both not null
        return dfs(root, subRoot);
    }

    public boolean ifSameTree(TreeNode root, TreeNode subRoot) {
        if (root != null) {// root!=null
            if (subRoot == null) {// subroot=null root!=null
                return false;
            } else {// subroot!=null root!=null
                if (root.val == subRoot.val) {
                    return ifSameTree(root.left, subRoot.left) && ifSameTree(root.right, subRoot.right);
                } else {
                    return false;
                }
            }

        } else {// root=null
            if (subRoot == root) {// subroot=root=null
                return true;
            } else {// subroot!=null root=null
                return false;
            }
        }

    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root != null) {
            if (ifSameTree(root, subRoot)) {
                return true;
            } else {
                return ifSameTree(root.left, subRoot) || ifSameTree(root.right, subRoot);
            }
        } else {
            return false;
        }
    }

//    public static void main(String[] args) {
//        TreeNode root= new TreeNode(1);
//        TreeNode subRoot=new TreeNode(1);
//        System.out.println(isSubtree(root,subRoot));
//    }
}
