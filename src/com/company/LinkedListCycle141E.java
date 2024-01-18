package com.company;

import java.util.HashSet;

/**
 * @program: Leetcode
 * @description:
 * @author: Mr.Wang
 * @create: 2024-01-18 15:04
 **/
public class LinkedListCycle141E {

     //Definition for singly-linked list.
      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
      val = x;
      next = null;
      }
      }

    public boolean hasCycle(ListNode head) {
        int pos = -1;
        ListNode node = head;
        HashSet<ListNode> set = new HashSet<>();

        if (head == null) {
            return false;
        }

        while (node.next != null) {
            if (set.contains(node)) {
                return true;
            } else {
                set.add(node);
                node = node.next;
            }
        }
        return false;
    }

}
