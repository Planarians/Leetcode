package com.company;

/**
 * @program: Leetcode
 * @description: Tree Depth-First Search Binary Tree
 * @author: Mr.Wang
 * @create: 2024-02-02 15:29
 **/
public class BalancedBinaryTree110E {



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
        public boolean isBalanced(TreeNode root) {


            if (root == null) {
                return true;
            }

            int [] array =dfs(root,1);

            if(array[0]==-1){
                return false;
            }else{
                return true;
            }
        }



        public int[] dfs(TreeNode root, int depth) {
            int leftDepth = depth;
            int rightDepth = depth;

            int [] array=new int [2];

            if(root!=null){

                if(root.left!=null){
                    int [] leftArray=dfs(root.left,depth+1);
                    if(leftArray[0]==-1){
                        array[0]=-1;
                        return array;
                    }
                    leftDepth=leftArray[1];
                }

                if(root.right!=null){
                    int [] rightArray=dfs(root.right,depth+1);
                    if(rightArray[0]==-1){
                        array[0]=-1;
                        return array;
                    }
                    rightDepth=rightArray[1];
                }

                if(leftDepth-rightDepth>1||rightDepth-leftDepth>1){
                    array[0]=-1;
                    return array;
                }else{
                    array[0]=1;
                }
                array[1]=Math.max(leftDepth,rightDepth);
            }

            return array;
        }
    }
}
