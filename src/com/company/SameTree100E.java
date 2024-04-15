package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-04-15 14:25
 **/
public class SameTree100E {

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

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return dfs(p,q);
        }
        public boolean dfs(TreeNode p,TreeNode q){
            if(p!=null&&q!=null){
                if(p.val==q.val){
                    return dfs(p.left,q.left)&&dfs(p.right,q.right);
                }
            }else{
                if(p==null&&q==null){
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}
