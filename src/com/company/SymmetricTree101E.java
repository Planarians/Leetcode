package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-17 23:09
 **/
public class SymmetricTree101E {

    //we need dfs on the left subtree and dfs on right subtree at the sam time

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

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        return dfs(root,root);
    }

    public Boolean dfs(TreeNode left,TreeNode right) {
        if (left != null&&right!=null) {
            if(left.val!=right.val){
                return false;
            }
            if(!dfs(left.right,right.left)||!dfs(left.left,right.right)){
                return false;
            }
        }else{
            if(left==null&&right!=null){
                return false;
            }
            if(right==null&&left!=null){
                return false;
            }
        }
        return true;
    }
}


/**
 * 1
 * 2   2
 * 2 n 2
 * <p>
 * <p>
 * /**
 * }
 */
