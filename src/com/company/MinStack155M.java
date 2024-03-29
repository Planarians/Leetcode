package com.company;

import java.util.Stack;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-14 00:05
 **/
public class MinStack155M {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;


        public MinStack() {
            stack=new Stack<>();
            min=new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if(min.isEmpty()){
                min.push(val);
            }else{
                min.push(min.peek()<val?min.peek():val);
            }
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
