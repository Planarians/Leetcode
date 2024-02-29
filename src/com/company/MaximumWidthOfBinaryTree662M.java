package com.company;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-29 17:56
 **/
public class MaximumWidthOfBinaryTree662M {
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

    class Solution2 {
        public int widthOfBinaryTree(TreeNode root) {
            int res=0;
            int first,last=0;
            if(root==null){
                return 0;
            }
            Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
            q.offer(new Pair<>(root,0));
            while(!q.isEmpty()){
                int min=q.peek().getValue();
                int size=q.size();
                first=0;
                last=0;
                for(int i=0;i<size;i++){
                    int cur_id=q.peek().getValue()-min;  //to make id start from 0
                    TreeNode node=q.peek().getKey();
                    q.poll();
                    if(i==0){
                        first=cur_id;
                    }
                    if(i==size-1){
                        last=cur_id;
                    }
                    if(node.left!=null){
                        q.offer(new Pair<>(node.left,cur_id*2+1));
                        // System.out.println("node: "+node.left.val+"value: "+(cur_id*2+1));

                    }
                    if(node.right!=null){
                        q.offer(new Pair<>(node.right,cur_id*2+2));
                        // System.out.println("node: "+node.right.val+"value: "+(cur_id*2+2));
                    }
                }
                res=Math.max(res,last-first+1);
                // System.out.println("res: "+res+"first: "+first+"last "+last);
            }
            return res;

        }
    }
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int ans = 0;
            Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>(); // {node, index}
            q.offer(new Pair<>(root, 1));

            while (!q.isEmpty()) {
                final int offset = q.peekFirst().getValue() * 2;
                ans = Math.max(ans, q.peekLast().getValue() - q.peekFirst().getValue() + 1);
                for (int sz = q.size(); sz > 0; --sz) {
                    final TreeNode node = q.peekFirst().getKey();
                    final int index = q.pollFirst().getValue();
                    if (node.left != null) {
                        q.offer(new Pair<>(node.left, index * 2 - offset));
                        System.out.println("node: "+node.left.val+"value: "+(index * 2 - offset));
                    }
                    if (node.right != null) {
                        q.offer(new Pair<>(node.right, index * 2 + 1 - offset));
                        System.out.println("node: "+node.right.val+"value: "+(index * 2 - offset));
                    }
                }
            }

            return ans;
        }
    }
}
