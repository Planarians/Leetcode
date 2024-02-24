package com.company;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-24 15:18
 **/
public class ValidateBinarySearchTree98M {
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
    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        private boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
            if (root == null){
                return true;
            }
            if (minNode != null && root.val <= minNode.val) {
                return false;
            }
            if (maxNode != null && root.val >= maxNode.val) {
                return false;
            }

            return                                      //
                    isValidBST(root.left, minNode, root) && //
                            isValidBST(root.right, root, maxNode);
        }
    }
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root==null){
                return false;
            }

            return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }

        public boolean dfs(TreeNode root,long left,long right){
            boolean ifLeft=false;
            boolean ifRight=false;
            if(root!=null){
                if(root.left!=null){
                    if(root.val<left&&root.val>right){
                        return false;
                    }
                    if(root.left.val<root.val&&root.left.val>left){
                        ifLeft=true;
                    }else{
                        return false;
                    }
                }else{
                    ifLeft=true;
                }
                if(root.right!=null){
                    if(root.right.val>root.val&&root.right.val<right){
                        ifRight=true;
                    }else{
                        return false;
                    }
                }else{
                    ifRight=true;
                }

                if(dfs(root.left,left,root.val)&&dfs(root.right,root.val,right)){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }
    }

/**


 5
 4    6
 null null 3 7




 */
}
