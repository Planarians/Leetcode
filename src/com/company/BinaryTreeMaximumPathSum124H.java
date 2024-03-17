package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-03-17 05:41
 **/
public class BinaryTreeMaximumPathSum124H {
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
        int [] res=new int[1];
        public int maxPathSum(TreeNode root) {
            res[0]=Integer.MIN_VALUE;
            // if(root==null){
            //     return 0;
            // }
            dfs(root);
            return res[0];
        }
        public int dfs(TreeNode root){
            int left=0;
            int right=0;
            if(root!=null){
                left=Math.max(0,dfs(root.left));
                right=Math.max(0,dfs(root.right));
                res[0]=Math.max(res[0],root.val+left+right);
                return root.val+Math.max(left,right);
            }else{
                return 0;
            }
        }
    }


/**
 if(root.left==null&&root.right==null){
 return root.val;
 }
 return root.left 
 */
}
