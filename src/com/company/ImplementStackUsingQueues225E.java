package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-02-18 01:25
 **/
public class ImplementStackUsingQueues225E {
    class MyStack {
        Queue<Integer> q;

        public MyStack() {
            q=new LinkedList<>();
        }

        public void push(int x) {
            q.offer(x);
            for(int i=0;i<q.size()-1;i++){
                q.offer(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();


 queue

 r     a
 12345
 54321


 stack
 12345
 a
 r



 */


}
