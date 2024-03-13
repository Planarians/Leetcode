package com.company;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2023-12-17 18:28
 **/
public class test {

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.poll()); // Output: 1
        System.out.println(queue.peek()); // Output: 2


        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // Output: 3
        System.out.println(stack.peek()); // Output: 2
    }
}
